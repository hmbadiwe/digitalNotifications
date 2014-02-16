package com.supersymmetry.digitalnotifications.dao;

import com.supersymmetry.digitalnotifications.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import static org.springframework.data.mongodb.core.query.Query.query;


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

    @Override
    public Order findByOrderNumber(String orderNumber, String orderType) {
        Order order;
        Query orderQuery = query(where("orderNumber").is(orderNumber));
        Class<? extends Order> orderClass;
        if( "Dsl".equals( orderType) ){
            orderClass = DslOrder.class;
        }
        else if("Telephone".equals(orderType)){
           orderClass = TelephoneOrder.class;
        }
        else if( "Uverse".equals( orderType ) ){
            orderClass = UverseOrder.class;
        }
        else{
            throw new IllegalArgumentException("Unknown order type");
        }

        order = mongoOperations.findOne(orderQuery, orderClass);
        return order;
    }
}
