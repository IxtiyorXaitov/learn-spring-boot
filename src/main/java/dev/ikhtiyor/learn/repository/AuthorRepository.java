package dev.ikhtiyor.learn.repository;

import dev.ikhtiyor.learn.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
