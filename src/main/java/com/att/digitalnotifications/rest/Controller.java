package com.att.digitalnotifications.rest;

import com.att.digitalnotifications.domain.Service;
import com.att.digitalnotifications.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/12/14
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */

@org.springframework.stereotype.Controller
@RequestMapping("/order/types")
public class Controller {
    Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    private OrderService orderService;

    @RequestMapping( method = RequestMethod.GET )
    @ResponseBody
    public List<Service> getOrderTypes(){
        logger.debug( "In get order types ");
        return orderService.availableServices();
    }
}