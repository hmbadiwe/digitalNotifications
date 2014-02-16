package com.att.digitalnotifications.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/15/14
 * Time: 11:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String message){
        super( message );
    }

}
