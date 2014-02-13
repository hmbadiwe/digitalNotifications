package com.att.digitalnotifications.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 12:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrderDao {
    @Autowired
    private MongoOperations mongoOperations;

    public List<String> orderTypes(){
        //return mongoOperations.findAll(String.class, )
        return new ArrayList<String>();
    }
}
