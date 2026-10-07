package com.yakko.splab.splabionutiacobescu.model;

public class Paragraph extends Element{
    private String text;
    private AlignStrategy textAlignment;

    public Paragraph (String t) {
        this.text=t;
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
}
