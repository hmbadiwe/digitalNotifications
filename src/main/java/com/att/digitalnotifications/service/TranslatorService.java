package com.att.digitalnotifications.service;

import com.att.digitalnotifications.domain.Order;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public interface TranslatorService {

    public String translate( String input, Order order );
}
