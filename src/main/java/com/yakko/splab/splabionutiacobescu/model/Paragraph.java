package com.yakko.splab.splabionutiacobescu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Paragraph extends Element{
    @Column
    private String text;

    @Transient
    private AlignStrategy textAlignment;

    public Paragraph() {
    }

    public Paragraph (String t) {
        this.text=t;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy textAlignment) {
        this.textAlignment = textAlignment;
    }

    @Override
    public String toString(){
        return text;
    }

    @Override
    public void print() {
        int hardcodedWidth = 150; // 30 characters wide terminal context

        if (textAlignment != null) {
            textAlignment.render(this, hardcodedWidth);
        } else {
            System.out.println(text);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
