package com.mystery.entity;

import com.alibaba.fastjson.annotation.JSONType;
import org.springframework.stereotype.Component;

@Component
@JSONType(orders={"id","name"})
public class College {
    private int id;
    private String name;

    public College(){}
    public College(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
