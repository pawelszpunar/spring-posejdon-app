package com.pawelszpunar.module.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksRestController {

    public static final List<BookEntity> BOOK_ENTITIES = List.of(
            new BookEntity().setId(1L).setTitle("Lorem 1").setAuthor("Author 1"),
            new BookEntity().setId(2L).setTitle("Lorem 2").setAuthor("Author 2"),
            new BookEntity().setId(3L).setTitle("Lorem 3").setAuthor("Author 3")
    );

    @GetMapping("/api/book")
    public List<BookEntity> getBook() {
        return BOOK_ENTITIES;
    }

    @GetMapping("/api/book/{id}")
    public BookEntity getBooks(@PathVariable Long id) {
        return BOOK_ENTITIES
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().get();
    }

}
