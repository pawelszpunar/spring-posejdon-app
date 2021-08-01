package com.pawelszpunar.module.book.mapper;

import com.pawelszpunar.module.book.dto.BookDto;
import com.pawelszpunar.module.book.entity.BookEntity;
import java.util.List;
import java.util.stream.Collectors;
public class BookMapper {
    public static BookDto map(BookEntity entity) {
        return new BookDto()
                .setId(entity.getId())
                .setAuthor(entity.getAuthor())
                .setTitle(entity.getTitle())
                .setDetails(BookDetailsMapper.map(entity.getDetails()))
                .setTags(BooksTagsMapper.map(entity.getTags()))
                .setTag(BooksTagsMapper.mapAsString(entity.getTags()));
    }
    public static List<BookDto> map(List<BookEntity> entities) {
        return entities
                .stream()
                .map(BookMapper::map)
                .collect(Collectors.toList());
    }
}
