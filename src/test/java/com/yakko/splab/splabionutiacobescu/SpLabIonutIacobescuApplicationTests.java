package com.yakko.splab.splabionutiacobescu;

import com.yakko.splab.splabionutiacobescu.model.*;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpLabIonutIacobescuApplicationTests {

    @Autowired
    private EntityManager entityManager;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void testSaveAndRetrieveBook() {
        Author a1 = new Author("John", "Doe");
        entityManager.persist(a1);

        Book book = new Book("Design Patterns in Java");
        book.addAuthor(a1);

        Section sec = new Section("Introduction");
        sec.add(new Paragraph("A sample paragraph."));
        sec.add(new Image("http://example.com/img.png"));
        book.addElement(sec);

        entityManager.persist(book);
        entityManager.flush();
        entityManager.clear();

        Book found = entityManager.find(Book.class, book.getId());
        assertNotNull(found);
        assertEquals("Design Patterns in Java", found.getTitle());
        assertEquals(1, found.getAuthors().size());
        assertEquals("John", found.getAuthors().get(0).getName());
        assertEquals(1, found.getElements().size());
    }

}
