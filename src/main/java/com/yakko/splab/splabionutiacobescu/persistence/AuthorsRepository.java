package com.yakko.splab.splabionutiacobescu.persistence;

import com.yakko.splab.splabionutiacobescu.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Integer> {
}
