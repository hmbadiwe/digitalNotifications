package com.supersymmetry.digitalnotifications.rest;

import com.supersymmetry.digitalnotifications.domain.Service;
import com.supersymmetry.digitalnotifications.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
