package com.yakko.splab.splabionutiacobescu.model;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents extends Element{
    private List<String> contents;

    public TableOfContents() {
        contents = new ArrayList<>();
    }

    public void addContent(String s){
        contents.add(s);
    }
    @Override
    public void print() {
        System.out.println("--- Table of Contents ---");
        for(String s : contents){
            System.out.println(s);
        }
    }
}
