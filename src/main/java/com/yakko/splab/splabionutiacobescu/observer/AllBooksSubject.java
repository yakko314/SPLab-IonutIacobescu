package com.yakko.splab.splabionutiacobescu.observer;

import com.yakko.splab.splabionutiacobescu.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject {

    private final List<Observer> observerCollection = new CopyOnWriteArrayList<>();
    private final List<Book> books = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void registerObserver(Observer observer) {
        observerCollection.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observerCollection.remove(observer);
    }

    @Override
    public void attach(Observer observer) {
        registerObserver(observer);
    }

    @Override
    public void detach(Observer observer) {
        unregisterObserver(observer);
    }

    @Override
    public void notifyObservers() {
        Book latest = books.isEmpty() ? null : books.get(books.size() - 1);
        notifyObservers(latest);
    }

    public void notifyObservers(Book book) {
        for (Observer observer : observerCollection) {
            observer.update(book);
        }
    }

    public void add(Book book) {
        this.books.add(book);
        notifyObservers(book);
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public List<Observer> getObserverCollection() {
        return Collections.unmodifiableList(observerCollection);
    }
}
