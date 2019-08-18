package com.bookstore.repository;

import com.bookstore.domain.Book;
import com.bookstore.model.EBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository  extends CrudRepository<EBook,Long> {
    List<EBook> findByAuthor(String author);
}
