package com.yakko.splab.splabionutiacobescu.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Section extends Element {
    @Column
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Element> elements;


    public Section() {
        elements = new ArrayList<>();
    }

    public Section(String t){
        this.title=t;
        elements = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public void add(Element element) {
        elements.add(element);
    }
    @Override
    public void remove(Element element){
        elements.remove(element);
    }
    @Override
    public Element get(int id){
        return elements.get(id);
    }

    public String getTitle(){
        return this.title;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(title).append("\n");
        for (Element elem : elements){
            sb.append(elem.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element child : elements) {
            child.accept(visitor);
        }
    }
}
