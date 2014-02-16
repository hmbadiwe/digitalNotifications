package com.att.digitalnotifications.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/14/14
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */

@Document( collection = "Uverse" )
public class UverseOrder extends Order {
    private String packageName;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
