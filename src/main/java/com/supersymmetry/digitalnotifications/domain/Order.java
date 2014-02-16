package com.supersymmetry.digitalnotifications.domain;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/14/14
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Order {
    private String orderNumber;
    private String address;
    private String name;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
