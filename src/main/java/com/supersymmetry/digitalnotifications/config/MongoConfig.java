package com.supersymmetry.digitalnotifications.config;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 1:00 AM
 * To change this template use File | Settings | File Templates.
 */
@PropertySource("classpath:app.properties")
@Configurable
public class MongoConfig {

    @Autowired
    private Environment env;
    public @Bean
    Mongo mongo() throws Exception {
        return new Mongo( new MongoURI(env.getProperty("mongo.db.uri") ));
    }
    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        String mongoDb =  env.getProperty("mongo.db.name");
        System.out.println( "Db name : " + mongoDb );
        UserCredentials credentials = new UserCredentials(
                env.getProperty("mongo.db.username"),
                env.getProperty("mongo.db.password")
        );
        return new MongoTemplate( mongo(), mongoDb, credentials );
    }

}
