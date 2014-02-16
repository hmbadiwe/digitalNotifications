package com.att.digitalnotifications.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/15/14
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class TranslatorResponseBody implements Serializable{
    public TranslatorResponseBody(){}
    public TranslatorResponseBody(String body){
        setBody(body);
    }
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
