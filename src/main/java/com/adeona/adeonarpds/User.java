package com.adeona.adeonarpds;

import java.util.List;

public class User {
    String name;
    String desc;
    List<String> urls;
    int type;
    public User(String name,String desc,List<String> urls,int type){
        this.name=name;
        this.desc=desc;
        this.urls=urls;
        this.type=type;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", urls=" + urls +
                ", type=" + type +
                '}';
    }
}