package com.yakko.splab.splabionutiacobescu.model;

public class Paragraph extends Element{
    private String text;

    public Paragraph (String t) {
        this.text=t;
    }
    @Override
    public String toString(){
        return text;
    }
    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
