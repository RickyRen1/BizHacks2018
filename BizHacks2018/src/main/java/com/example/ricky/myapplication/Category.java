package com.example.ricky.myapplication;


import java.util.ArrayList;

/**
 * Created by nghev01 on 2018-03-23.
 */

public class Category extends Directory {

    ArrayList<Directory> directorylist;

    public Category (String name, String id) {
        super(name, id);
        this.directorylist = new ArrayList<Directory>();
    }

    public void addDirectory(Directory dir) {
        this.directorylist.add(dir);
    }

    private void setDirectoryList(ArrayList<Directory> arr) {
        directorylist = arr;
    }

}
