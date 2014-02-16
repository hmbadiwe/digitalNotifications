package com.supersymmetry.digitalnotifications.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestAppInitializer implements WebApplicationInitializer {
    private Logger logger  = LoggerFactory.getLogger(RestAppInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) {
        WebApplicationContext rootContext = createRootContext(servletContext);

        configureSpringMvc(servletContext, rootContext);
    }

    private WebApplicationContext createRootContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(MongoConfig.class);
        rootContext.refresh();

        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.setInitParameter("defaultHtmlEscape", "true");

        return rootContext;
    }

    private void configureSpringMvc(ServletContext servletContext, WebApplicationContext rootContext) {
        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(AppConfig.class);

        mvcContext.setParent(rootContext);

        ServletRegistration.Dynamic appServlet = servletContext.addServlet(
                "webservice", new DispatcherServlet(mvcContext));
        appServlet.setLoadOnStartup(1);
        Set<String> mappingConflicts = appServlet.addMapping("/rest/*");

        if (!mappingConflicts.isEmpty()) {
            for (String s : mappingConflicts) {
                logger.error("Mapping conflict: " + s);
            }
            throw new IllegalStateException(
                    "'webservice' cannot be mapped to '/rest'");
        }
    }

}
