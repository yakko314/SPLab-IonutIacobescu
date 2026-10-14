package com.yakko.splab.splabionutiacobescu.model;

public interface Visitor {
    public void visit(Book b);
    public void visit(Paragraph p);
    public void visit(Table t);
    public void visit(Image i);

    public void visit(Section section);
}
