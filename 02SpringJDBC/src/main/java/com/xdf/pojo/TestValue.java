package com.xdf.pojo;

import org.springframework.beans.factory.annotation.Value;

public class TestValue {


    @Value("${jdbc.url}")
    private  String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
