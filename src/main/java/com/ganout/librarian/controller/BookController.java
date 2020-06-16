package com.ganout.librarian.controller;

import com.ganout.librarian.entity.Book;
import com.ganout.librarian.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {

        return bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<Book> findAllBook(){

        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Book findBookById(@PathVariable Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {

        return bookRepository.save(book);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBook(@PathVariable Long id) {

        bookRepository.deleteById(id);
        return true;
    }

    @GetMapping("search/{keyWords}")
    public List<Book> findByWordContaining(@PathVariable String keyWords) {

        return bookRepository.findAllByTitleContainsOrDescriptionContains(keyWords, keyWords);
    }
}
