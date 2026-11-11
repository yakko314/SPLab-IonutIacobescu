package com.yakko.splab.splabionutiacobescu.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "element_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class Element {
    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void accept (Visitor v){
        throw new UnsupportedOperationException();
    }
}
