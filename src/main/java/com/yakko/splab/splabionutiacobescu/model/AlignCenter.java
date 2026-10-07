package com.yakko.splab.splabionutiacobescu.model;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, int contextWidth) {
        String text = paragraph.toString();
        if (text.length() >= contextWidth) {
            System.out.println(text);
        } else {
            int totalPadding = contextWidth - text.length();
            int leftPadding = totalPadding / 2;
            int rightPadding = totalPadding - leftPadding;

            System.out.println(" ".repeat(leftPadding) + text + " ".repeat(rightPadding));
        }
    }
}