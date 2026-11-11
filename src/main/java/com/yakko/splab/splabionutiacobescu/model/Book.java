package com.yakko.splab.splabionutiacobescu.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable
    private List<Author> authors;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Element> elements;

    public Book() {
        authors = new ArrayList<>();
        elements = new ArrayList<>();
    }

    public Book(String t){
        this.title = t;
        authors = new ArrayList<>();
        elements = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element child : elements) {
            child.accept(visitor);
        }
    }
}
