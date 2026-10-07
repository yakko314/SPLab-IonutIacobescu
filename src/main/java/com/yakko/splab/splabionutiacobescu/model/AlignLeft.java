package com.yakko.splab.splabionutiacobescu.model;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, int contextWidth) {
        String text = paragraph.toString();
        if (text.length() >= contextWidth) {
            System.out.println(text);
        } else {
            String padding = " ".repeat(contextWidth - text.length());
            System.out.println(text + padding);
        }
    }
}