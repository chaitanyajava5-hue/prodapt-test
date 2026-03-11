
package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.GoogleBookResponse;
import com.example.demo.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);

    @Mapping(target="author", expression="java(item.volumeInfo().authors()!=null && !item.volumeInfo().authors().isEmpty()?item.volumeInfo().authors().get(0):null)")
    @Mapping(target="title", source="volumeInfo.title")
    @Mapping(target="publisher", source="volumeInfo.publisher")
    Book googleToEntity(GoogleBookResponse.Item item);
}
