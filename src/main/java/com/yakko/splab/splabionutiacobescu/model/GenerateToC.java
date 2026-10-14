package com.yakko.splab.splabionutiacobescu.model;

import java.util.ArrayList;
import java.util.List;

public class GenerateToC implements Visitor{
    private List<String> contents = new ArrayList<>();
    private int pageCount=0;
    public TableOfContents getToC(){
        TableOfContents t = new TableOfContents();
        for(String s : contents){
            t.addContent(s);
        }
        return t;
    }

    @Override
    public void visit(Book b) {
        ;
    }

    @Override
    public void visit(Section section) {
        contents.add(section.getTitle() + " ......... pg " + pageCount);
    }

    @Override
    public void visit(Paragraph p) {
        pageCount++;
    }

    @Override
    public void visit(Table t) {
        pageCount++;
    }

    @Override
    public void visit(Image i) {
        pageCount++;
    }



}
