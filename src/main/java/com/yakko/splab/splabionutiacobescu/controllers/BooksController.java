package com.yakko.splab.splabionutiacobescu.controllers;

import com.yakko.splab.splabionutiacobescu.model.Book;
import com.yakko.splab.splabionutiacobescu.persistence.CrudRepository;
import com.yakko.splab.splabionutiacobescu.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final CrudRepository<Book, Integer> booksRepository;
    private final CommandContext commandContext;

    @Autowired
    public BooksController(CrudRepository<Book, Integer> booksRepository, CommandContext commandContext) {
        this.booksRepository = booksRepository;
        this.commandContext = commandContext;
        this.commandContext.setBooksRepository(booksRepository);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = new GetAllBooksCommand(commandContext).execute();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id) {
        Book book = new GetBookByIdCommand(id, commandContext).execute();
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody(required = false) Book book) {
        if (book == null) {
            book = new Book();
        }
        Book created = new CreateBookCommand(book, commandContext).execute();
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updated = new UpdateBookCommand(id, book, commandContext).execute();
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        new DeleteBookCommand(id, commandContext).execute();
        return ResponseEntity.noContent().build();
    }
}
