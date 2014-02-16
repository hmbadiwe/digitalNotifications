package com.att.digitalnotifications.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/14/14
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Document( collection = "Telephone" )
public class TelephoneOrder extends Order {
    private String phoneNumber;
    private String serviceType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
