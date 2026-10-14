package com.yakko.splab.splabionutiacobescu.model;

public class BookStatistics implements Visitor {
    private int paragraphCnt=0;
    private int tableCnt=0;
    private int imgCnt=0;
    @Override
    public void visit(Book b) {
        ;
    }

    @Override
    public void visit(Section section) {
        ;
    }

    @Override
    public void visit(Paragraph p) {
        paragraphCnt++;
    }

    @Override
    public void visit(Table t) {
        tableCnt++;
    }

    @Override
    public void visit(Image i) {
        imgCnt++;
    }



    public void printStatistics() {
        System.out.println("--- Book Statistics ---");
        System.out.println("Paragraphs: " + paragraphCnt);
        System.out.println("Images: " + imgCnt);
        System.out.println("Tables: " + tableCnt);
    }
}
