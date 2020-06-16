package com.ganout.librarian.repository;

import com.ganout.librarian.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleContainsOrDescriptionContains(String title, String description);
}
