package com.yakko.splab.splabionutiacobescu.model;

import java.util.ArrayList;
import java.util.List;

public class Section extends Element {
    private String title;
    private List<Element> elements;


    public Section(String t){
        this.title=t;
        elements = new ArrayList<>();
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

}
