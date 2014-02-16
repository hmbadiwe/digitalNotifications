package com.supersymmetry.digitalnotifications.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/14/14
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Document( collection = "Dsl")
public class DslOrder extends Order {
    private String packageName;
    private String speed;
    private String modem;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getModem() {
        return modem;
    }

    public void setModem(String modem) {
        this.modem = modem;
    }
}
