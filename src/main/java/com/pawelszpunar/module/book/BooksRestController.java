package com.pawelszpunar.module.book;

import com.pawelszpunar.module.book.dto.BookDto;
import com.pawelszpunar.module.book.entity.BookEntity;
import com.pawelszpunar.module.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BooksRestController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/api/book")
    public List<BookDto> getBooks() {
        List<BookEntity> books = bookRepository.findAll();
        return BookMapper.map(books);
    }

    @GetMapping("/api/book/{id}")
    public BookDto getBook(@PathVariable Long id) {
        BookEntity book = bookRepository.findOneById(id);
        return BookMapper.map(book);
    }

    @PostMapping("/api/book")
    public BookDto newBook(@RequestBody @Valid BookEntity booksEntity) {
        BookEntity book = bookRepository.saveAndFlush(booksEntity);
        return BookMapper.map(book);
    }

    @PutMapping("/api/book/{id}")
    public BookDto updateBooks(@PathVariable Long id,
                               @RequestBody BookEntity booksEntity) {
        BookEntity book = bookRepository.saveAndFlush(booksEntity.setId(id));
        return BookMapper.map(book);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteBook(@PathVariable Long id) {
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
