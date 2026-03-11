
package com.example.demo.service;

import com.example.demo.client.GoogleBookClient;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.GoogleBookResponse;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final GoogleBookClient googleBookClient;
    private final BookRepository repository;
    private final BookMapper mapper;

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    public List<BookDto> searchAndSave(String query){

        log.info("Calling Google Books API");

        GoogleBookResponse response = googleBookClient.searchBooks(query);

        if(response == null || response.items()==null)
            throw new RuntimeException("Invalid response from Google API");

        List<Book> books = response.items()
                .stream()
                .map(mapper::googleToEntity)
                .toList();

        repository.saveAll(books);

        log.info("Saved {} books", books.size());

        return books.stream().map(mapper::toDto).toList();
    }
}
