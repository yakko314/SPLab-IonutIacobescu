package com.yakko.splab.splabionutiacobescu.model;


import java.util.ArrayList;
import java.util.List;


public class Book {
    private String title;
    private List<Author> authors;
    private List<Element> elements;

    public Book(String t){
        this.title = t;
        authors = new ArrayList<>();
        elements = new ArrayList<>();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(title).append("\"");
        if (!authors.isEmpty()){
            sb.append(" by ").append(authors.get(0));
            if(authors.size() > 1){
                for (int i = 1; i < authors.size(); i++){
                    sb.append(", ");
                    sb.append(authors.get(i));
                }
            }
        }
        sb.append(".\n");
        for (Element e : elements) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }

    public void addAuthor(Author a){
        authors.add(a);
    }
    public void removeAuthor(Author a){
        authors.remove(a);
    }

    public void addElement(Element elem){
        elements.add(elem);
    }
    public void removeElement(Element elem){
        elements.remove(elem);
    }

    public void print(){
        System.out.println(this.toString());
    }
}
