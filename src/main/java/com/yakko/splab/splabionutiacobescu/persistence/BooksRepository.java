package com.yakko.splab.splabionutiacobescu.persistence;

import com.yakko.splab.splabionutiacobescu.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
}
