package com.yakko.splab.splabionutiacobescu.services;

import com.yakko.splab.splabionutiacobescu.model.Book;

public class UpdateBookCommand implements Command<Book> {

    private final int id;
    private final Book bookData;
    private final CommandContext context;

    public UpdateBookCommand(int id, Book bookData, CommandContext context) {
        this.id = id;
        this.bookData = bookData;
        this.context = context;
    }

    @Override
    public Book execute() {
        return context.getBooksRepository().findById(id).map(existing -> {
            if (bookData != null) {
                if (bookData.getTitle() != null) {
                    existing.setTitle(bookData.getTitle());
                }
                if (bookData.getAuthors() != null) {
                    existing.setAuthors(bookData.getAuthors());
                }
                if (bookData.getElements() != null) {
                    existing.setElements(bookData.getElements());
                }
            }
            return context.getBooksRepository().save(existing);
        }).orElse(null);
    }
}
