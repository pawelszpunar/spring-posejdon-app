package com.pawelszpunar.module.book;

import com.pawelszpunar.module.book.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {
    BookEntity findOneById(Long id);
}
//BookEntity findAllByAuthor (String author);