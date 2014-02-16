package com.att.digitalnotifications.dao;

import com.att.digitalnotifications.domain.Order;
import com.att.digitalnotifications.domain.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface OrderDao {

    public List<Service> orderTypes();
    public Order findByOrderNumber(String orderNumber, String orderType);
}
