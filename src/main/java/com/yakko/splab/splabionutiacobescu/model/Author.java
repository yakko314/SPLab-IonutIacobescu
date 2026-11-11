package com.yakko.splab.splabionutiacobescu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Table;


@Entity
@Table(name="authors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;
    @Column
    private String surname;

    public Author() {
    }

    public Author(String n, String s){
        this.name=n;
        this.surname=s;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Override
    public String toString(){
        return name + " " + surname;
    }
    public void print(){
        System.out.println(this.toString());
    }
}
