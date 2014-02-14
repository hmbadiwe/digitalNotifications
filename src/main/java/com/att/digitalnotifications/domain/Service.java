package com.att.digitalnotifications.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Service implements Serializable{
    private String name;
    private List<String> params = new ArrayList<String>();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
