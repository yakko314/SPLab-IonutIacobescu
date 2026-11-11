package com.yakko.splab.splabionutiacobescu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "book_tables")
public class Table extends Element {

    @Column
    private String something;

    public Table() {
    }

    public Table(String something) {
        this.something = something;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("Table: " + something);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
