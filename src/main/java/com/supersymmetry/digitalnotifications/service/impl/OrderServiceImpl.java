package com.supersymmetry.digitalnotifications.service.impl;

import com.supersymmetry.digitalnotifications.dao.OrderDao;
import com.supersymmetry.digitalnotifications.domain.Order;
import com.supersymmetry.digitalnotifications.domain.Service;
import com.supersymmetry.digitalnotifications.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/12/14
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Service> availableServices() {
        List<String> returnList = new ArrayList<String>();

        List<Service> serviceList =  orderDao.orderTypes();
        return serviceList;
    }

    @Override
    public Order findByOrderNumber(String orderNumber, String orderType) {
        Order order = orderDao.findByOrderNumber( orderNumber, orderType );
        return order;
    }
}
