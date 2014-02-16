package com.supersymmetry.digitalnotifications.domain;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/14/14
 * Time: 10:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class TranslatorPayload {
    private String orderId;
    private String orderType;
    private String messageBody;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
