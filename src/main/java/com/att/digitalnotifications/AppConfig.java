package com.att.digitalnotifications;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 1:00 AM
 * To change this template use File | Settings | File Templates.
 */
@Configurable
public class AppConfig {
    public @Bean
    Mongo mongo() throws Exception {
        return new Mongo("localhost");
    }
    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate( mongo(), "digital_notif");
    }

}
