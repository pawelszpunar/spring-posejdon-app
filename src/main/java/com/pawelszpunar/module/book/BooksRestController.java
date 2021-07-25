package com.pawelszpunar.module.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/api/book")
    public List<BookEntity> getBook() {
        return bookRepository.findAll();
    }

    @GetMapping("/api/book/{id}")
    public BookEntity getBooks(@PathVariable Long id) {
        return bookRepository.findOneById(id);
    }

    @PostMapping("/api/book")
    public BookEntity newBooks(@RequestBody BookEntity booksEntity) {
        return bookRepository.saveAndFlush(booksEntity);
    }

    @PutMapping("/api/book/{id}")
    public BookEntity updateBooks(@PathVariable Long id,
                                  @RequestBody BookEntity booksEntity) {
        return bookRepository.saveAndFlush(booksEntity.setId(id));
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteBooks(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

}

//===========NOTES========================================================================

//    @Autowired
//    private BookRepository bookRepository;
//
////    public static final List<BookEntity> BOOK_ENTITIES = List.of(
////            new BookEntity().setId(1L).setTitle("Lorem 1").setAuthor("Author 1"),
////            new BookEntity().setId(2L).setTitle("Lorem 2").setAuthor("Author 2"),
////            new BookEntity().setId(3L).setTitle("Lorem 3").setAuthor("Author 3")
////    );
//
//    @GetMapping("/api/book")
//    public List<BookEntity> getBook() {
//        return bookRepository.findAll();
////        return BOOK_ENTITIES;
//    }
//
//    @GetMapping("/api/book/{id}")
//    public BookEntity getBooks(@PathVariable Long id) {
//        return bookRepository.findOneById(id);
////        return BOOK_ENTITIES
////                .stream()
////                .filter(item -> item.getId().equals(id))
////
