package dev.ikhtiyor.learn.repository;

import dev.ikhtiyor.learn.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
