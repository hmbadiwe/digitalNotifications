package com.att.digitalnotifications.service.impl;

import com.att.digitalnotifications.service.OrderService;
import com.att.digitalnotifications.service.TranslatorService;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class TranslatorServiceImpl implements TranslatorService {

    private VelocityEngine ve = null;

    @Autowired
    private OrderService orderService;

    public VelocityEngine getVelocityEngine(){
        if( ve != null ){
            ve = new VelocityEngine();
            //ve.setProperty( VelocityEngine.RUN);
        }
        return ve;
    }

    public String translate(String input, String orderNumber){
        VelocityContext context = new VelocityContext();
        StringWriter writer = new StringWriter();
         getVelocityEngine().evaluate( context, writer, "log_tag", input );
        return writer.toString();
    }
}
