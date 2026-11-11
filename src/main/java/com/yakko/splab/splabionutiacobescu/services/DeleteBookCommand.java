package com.yakko.splab.splabionutiacobescu.services;

public class DeleteBookCommand implements Command<Void> {

    private final int id;
    private final CommandContext context;

    public DeleteBookCommand(int id, CommandContext context) {
        this.id = id;
        this.context = context;
    }

    @Override
    public Void execute() {
        context.getBooksRepository().deleteById(id);
        return null;
    }
}
