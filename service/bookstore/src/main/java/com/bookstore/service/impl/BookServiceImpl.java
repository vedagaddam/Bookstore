package com.bookstore.service.impl;

import com.bookstore.domain.Book;
import com.bookstore.model.EBook;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;
import com.bookstore.util.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Book saveBook(Book book) {
        EBook eBook=bookMapper.convertToEntity().apply(book);
        eBook= bookRepository.save(eBook);
        return bookMapper.convertToModel().apply(eBook);
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> books=new ArrayList<>();
        Consumer<EBook> eBookConsumer=(EBook ebook)->{
            Book book=bookMapper.convertToModel().apply(ebook);
            books.add(book);
        };
         bookRepository.findAll().forEach(eBookConsumer);
         return books;
    }

    @Override
    public Book fetchBookById(Long id) {
        EBook eBook= bookRepository.findOne(id);
        return  bookMapper.convertToModel().apply(eBook);
    }

}
