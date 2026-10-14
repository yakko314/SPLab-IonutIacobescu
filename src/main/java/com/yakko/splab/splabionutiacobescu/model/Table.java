package com.yakko.splab.splabionutiacobescu.model;

public class Table extends Element {
    @Override
    public void print() {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
