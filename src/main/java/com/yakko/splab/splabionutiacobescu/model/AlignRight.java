package com.yakko.splab.splabionutiacobescu.model;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, int contextWidth) {
        String text = paragraph.toString();
        if (text.length() >= contextWidth) {
            System.out.println(text);
        } else {
            // Right-aligned: print padding spaces before the text
            String padding = " ".repeat(contextWidth - text.length());
            System.out.println(padding + text);
        }
    }
}