package com.yakko.splab.splabionutiacobescu.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity

public class Image extends Element {
    @Column
    private String url;

    public Image() {
    }

    public Image (String t) {
        this.url=t;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString(){
        return url;
    }
    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
