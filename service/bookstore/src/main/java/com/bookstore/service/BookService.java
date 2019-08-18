package com.bookstore.service;

import com.bookstore.domain.Book;

import java.util.List;

public interface BookService {
     Book saveBook(Book book);

     List<Book> findAllBooks();

     Book fetchBookById(Long id);

}
