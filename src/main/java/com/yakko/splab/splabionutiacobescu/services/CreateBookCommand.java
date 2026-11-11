package com.yakko.splab.splabionutiacobescu.services;

import com.yakko.splab.splabionutiacobescu.model.Book;

public class CreateBookCommand implements Command<Book> {

    private Book book;
    private final CommandContext context;

    public CreateBookCommand(Book book, CommandContext context) {
        this.book = book;
        this.context = context;
    }

    public CreateBookCommand(CommandContext context) {
        this(new Book(), context);
    }

    @Override
    public Book execute() {
        if (this.book == null) {
            this.book = new Book();
        }
        return context.getBooksRepository().save(this.book);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
