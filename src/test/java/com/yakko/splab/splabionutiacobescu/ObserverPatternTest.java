package com.yakko.splab.splabionutiacobescu;

import com.yakko.splab.splabionutiacobescu.controllers.BooksController;
import com.yakko.splab.splabionutiacobescu.controllers.BooksSseController;
import com.yakko.splab.splabionutiacobescu.model.Book;
import com.yakko.splab.splabionutiacobescu.observer.AllBooksSubject;
import com.yakko.splab.splabionutiacobescu.observer.Observer;
import com.yakko.splab.splabionutiacobescu.observer.SseObserver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ObserverPatternTest {

    @Autowired
    private AllBooksSubject allBooksSubject;

    @Autowired
    private BooksSseController booksSseController;

    @Autowired
    private BooksController booksController;

    @Test
    void testSubjectRegisterAndNotify() {
        AllBooksSubject subject = new AllBooksSubject();
        List<Book> receivedBooks = new ArrayList<>();

        Observer observer = new Observer() {
            @Override
            public void update(Book book) {
                receivedBooks.add(book);
            }
        };

        subject.registerObserver(observer);
        assertEquals(1, subject.getObserverCollection().size());

        Book book1 = new Book("Book 1");
        subject.add(book1);

        assertEquals(1, receivedBooks.size());
        assertEquals("Book 1", receivedBooks.get(0).getTitle());

        subject.unregisterObserver(observer);
        assertEquals(0, subject.getObserverCollection().size());

        subject.add(new Book("Book 2"));
        assertEquals(1, receivedBooks.size());
    }

    @Test
    void testAttachAndDetachAliases() {
        AllBooksSubject subject = new AllBooksSubject();
        final AtomicReference<Book> notified = new AtomicReference<>();

        Observer obs = notified::set;
        subject.attach(obs);
        assertEquals(1, subject.getObserverCollection().size());

        Book b = new Book("Observed Book");
        subject.add(b);
        assertEquals(b, notified.get());

        subject.detach(obs);
        assertEquals(0, subject.getObserverCollection().size());
    }

    @Test
    void testSseObserverUpdate() {
        SseEmitter emitter = new SseEmitter();
        SseObserver sseObserver = new SseObserver(emitter);
        assertNotNull(sseObserver.getEmitter());

        Book book = new Book("SSE Book");
        book.setId(42);
        // Should not throw
        assertDoesNotThrow(() -> sseObserver.update(book));
    }

    @Test
    void testBooksSseController() {
        ResponseBodyEmitter emitter = booksSseController.getBooksSse();
        assertNotNull(emitter);
        assertTrue(emitter instanceof SseEmitter);
    }

    @Test
    void testCreateBookNotifiesAllBooksSubject() {
        final AtomicReference<Book> received = new AtomicReference<>();
        Observer testObserver = received::set;

        allBooksSubject.attach(testObserver);
        try {
            Book book = new Book("Notification Test Book");
            booksController.createBook(book);

            assertNotNull(received.get());
            assertEquals("Notification Test Book", received.get().getTitle());
        } finally {
            allBooksSubject.detach(testObserver);
        }
    }
}
