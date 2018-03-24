package com.example.ricky.myapplication;


/**
 * Created by nghev01 on 2018-03-23.
 */

public class Directory {

    String name;
    String id;
    Directory parent;


    public Directory(String name, String id) {
        setName(name);
        setId(id);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setId (String id) {
        this.id = id;
    }

    public void setParent(Directory dir) {
        this.parent = dir;
    }

    public String getName() { return this.name;}
    public String getId() { return this.id; }

}
