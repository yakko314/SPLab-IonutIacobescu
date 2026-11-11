package com.yakko.splab.splabionutiacobescu.observer;

import com.yakko.splab.splabionutiacobescu.model.Book;

public interface Observer {
    void update(Book book);

    default void update() {
        update(null);
    }
}
