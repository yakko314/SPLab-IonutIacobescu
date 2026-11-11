package com.yakko.splab.splabionutiacobescu.services;

import com.yakko.splab.splabionutiacobescu.model.Book;

public class GetBookByIdCommand implements Command<Book> {

    private final int id;
    private final CommandContext context;

    public GetBookByIdCommand(int id, CommandContext context) {
        this.id = id;
        this.context = context;
    }

    @Override
    public Book execute() {
        return context.getBooksRepository().findById(id).orElse(null);
    }
}
