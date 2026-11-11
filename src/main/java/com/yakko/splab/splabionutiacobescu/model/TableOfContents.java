package com.yakko.splab.splabionutiacobescu.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TableOfContents extends Element {

    @Column
    private String something;

    @ElementCollection
    private List<String> contents;

    public TableOfContents() {
        contents = new ArrayList<>();
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public void addContent(String s){
        contents.add(s);
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }

    @Override
    public void print() {
        System.out.println("--- Table of Contents ---");
        for(String s : contents){
            System.out.println(s);
        }
    }

    @Override
    public void accept(Visitor visitor) {
    }
}
