package com.yakko.splab.splabionutiacobescu.model;

public abstract class Element {
    public abstract void print();

    public void add(Element element) {
        throw new UnsupportedOperationException();
    }
    public void remove(Element element) {
        throw new UnsupportedOperationException();
    }
    public Element get(int index) {
        throw new UnsupportedOperationException();
    }
}
