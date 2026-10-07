package com.yakko.splab.splabionutiacobescu.model;

public class Image extends Element {
    private String url;

    public Image (String t) {
        this.url=t;
    }
    @Override
    public String toString(){
        return url;
    }
    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
