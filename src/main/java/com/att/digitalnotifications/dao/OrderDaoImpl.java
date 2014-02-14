package com.att.digitalnotifications.dao;

import com.att.digitalnotifications.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 12:57 AM
 * To change this template use File | Settings | File Templates.
 */

@Component
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private MongoOperations mongoOperations;

    public List<Service> orderTypes(){
        List<Service> services = mongoOperations.findAll(Service.class, "services" );
        return services;

    }
}
