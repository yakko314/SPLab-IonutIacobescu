package com.yakko.splab.splabionutiacobescu;

import com.yakko.splab.splabionutiacobescu.controllers.BooksController;
import com.yakko.splab.splabionutiacobescu.model.Author;
import com.yakko.splab.splabionutiacobescu.model.Book;
import com.yakko.splab.splabionutiacobescu.model.Paragraph;
import com.yakko.splab.splabionutiacobescu.model.Section;
import com.yakko.splab.splabionutiacobescu.persistence.CrudRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BooksControllerTest {

    @Autowired
    private BooksController booksController;

    @Autowired
    private CrudRepository<Book, Integer> booksRepository;

    @BeforeEach
    void setUp() {
        for (Book book : booksRepository.findAll()) {
            booksRepository.deleteById(book.getId());
        }
    }

    @Test
    void testCreateBook() {
        Book book = new Book("Design Patterns");
        Author author = new Author("Erich", "Gamma");
        book.addAuthor(author);

        Section section = new Section("Creational Patterns");
        section.add(new Paragraph("Factory Method"));
        book.addElement(section);

        ResponseEntity<Book> response = booksController.createBook(book);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Book created = response.getBody();
        assertNotNull(created);
        assertTrue(created.getId() > 0);
        assertEquals("Design Patterns", created.getTitle());
        assertEquals(1, created.getAuthors().size());
        assertEquals("Erich", created.getAuthors().get(0).getName());
        assertEquals(1, created.getElements().size());
    }

    @Test
    void testGetAllBooks() {
        booksController.createBook(new Book("Book 1"));
        booksController.createBook(new Book("Book 2"));

        ResponseEntity<List<Book>> response = booksController.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Book> books = response.getBody();
        assertNotNull(books);
        assertEquals(2, books.size());
    }

    @Test
    void testGetBookById() {
        ResponseEntity<Book> createResponse = booksController.createBook(new Book("Spring Boot in Action"));
        assertNotNull(createResponse.getBody());
        int id = createResponse.getBody().getId();

        ResponseEntity<Book> response = booksController.getById(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Spring Boot in Action", response.getBody().getTitle());
    }

    @Test
    void testGetBookByIdNotFound() {
        ResponseEntity<Book> response = booksController.getById(9999);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdateBook() {
        ResponseEntity<Book> createResponse = booksController.createBook(new Book("Old Title"));
        assertNotNull(createResponse.getBody());
        int id = createResponse.getBody().getId();

        Book updateData = new Book("New Title");
        ResponseEntity<Book> updateResponse = booksController.updateBook(id, updateData);
        assertEquals(HttpStatus.OK, updateResponse.getStatusCode());
        assertNotNull(updateResponse.getBody());
        assertEquals("New Title", updateResponse.getBody().getTitle());

        ResponseEntity<Book> fetchResponse = booksController.getById(id);
        assertEquals("New Title", fetchResponse.getBody().getTitle());
    }

    @Test
    void testDeleteBook() {
        ResponseEntity<Book> createResponse = booksController.createBook(new Book("To Delete"));
        assertNotNull(createResponse.getBody());
        int id = createResponse.getBody().getId();

        ResponseEntity<Void> deleteResponse = booksController.deleteBook(id);
        assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());

        ResponseEntity<Book> fetchResponse = booksController.getById(id);
        assertEquals(HttpStatus.NOT_FOUND, fetchResponse.getStatusCode());
    }
}
