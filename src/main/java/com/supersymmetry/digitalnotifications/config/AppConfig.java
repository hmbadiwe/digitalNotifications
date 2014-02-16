package com.supersymmetry.digitalnotifications.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 5:37 PM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.supersymmetry.digitalnotifications")
public class AppConfig {

}
