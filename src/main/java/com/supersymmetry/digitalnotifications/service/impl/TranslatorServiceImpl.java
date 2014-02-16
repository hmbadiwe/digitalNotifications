package com.supersymmetry.digitalnotifications.service.impl;

import com.supersymmetry.digitalnotifications.domain.Order;
import com.supersymmetry.digitalnotifications.service.TranslatorService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class TranslatorServiceImpl implements TranslatorService {


    public String translate(String input, Order order){
        try{
            Template t = new Template("name", new StringReader(input), new Configuration());
            StringWriter writer = new StringWriter();
            t.process( order, writer );
            return writer.toString();
        }
        catch( Exception e ){
           throw new RuntimeException("Error processing template");
        }
    }
}
