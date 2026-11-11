package com.yakko.splab.splabionutiacobescu.services;

import com.yakko.splab.splabionutiacobescu.model.Book;
import com.yakko.splab.splabionutiacobescu.persistence.BooksRepository;
import com.yakko.splab.splabionutiacobescu.persistence.BooksRepositoryAdapter;
import com.yakko.splab.splabionutiacobescu.persistence.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandContext {

    private CrudRepository<Book, Integer> booksRepository;

    public CommandContext() {
    }

    @Autowired
    public CommandContext(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public CommandContext(BooksRepository booksRepository) {
        this.booksRepository = new BooksRepositoryAdapter(booksRepository);
    }

    public CrudRepository<Book, Integer> getBooksRepository() {
        return booksRepository;
    }

    public void setBooksRepository(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void setBooksRepository(BooksRepository booksRepository) {
        this.booksRepository = new BooksRepositoryAdapter(booksRepository);
    }
}
