package com.att.digitalnotifications.service;


import com.att.digitalnotifications.domain.Order;
import com.att.digitalnotifications.domain.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/12/14
 * Time: 11:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface OrderService {
    public List<Service> availableServices();
    public Order findByOrderNumber(String orderNumber, String orderType);

}
