package com.yakko.splab.splabionutiacobescu.model;

public class Author {
    private String name;
    private String surname;

    public Author(String n, String s){
        this.name=n;
        this.surname=s;
    }
    @Override
    public String toString(){
        return name + " " + surname;
    }
    public void print(){
        System.out.println(this.toString());
    }
}
