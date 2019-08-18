package com.bookstore.util;

import com.bookstore.domain.Book;
import com.bookstore.model.EBook;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class BookMapper {
    public Function<Book, EBook> convertToEntity(){
        Function<Book, EBook> mapper=(Book b)->{
            EBook eBook=new EBook();
            eBook.setId(b.getId());
            eBook.setActive(b.isActive());
            eBook.setAuthor(b.getAuthor());
            eBook.setCategory(b.getCategory());
            eBook.setDescription(b.getDescription());
            eBook.setTitle(b.getTitle());
            eBook.setPublisher(b.getPublisher());
            eBook.setPublicationDate(b.getPublicationDate());
            eBook.setLanguage(b.getLanguage());
            eBook.setNumberOfPages(b.getNumberOfPages());
            eBook.setFormat(b.getFormat());
            eBook.setIsbn(b.getIsbn());
            eBook.setShippingWeight(b.getShippingWeight());
            eBook.setListPrice(b.getListPrice());
            eBook.setOurPrice(b.getOurPrice());
            eBook.setInStockNumber(b.getInStockNumber());

            return eBook;
        };
        return mapper;
    }
    public Function<EBook,Book> convertToModel(){

        Function<EBook,Book> mapper=(eBook)->{
            Book b=Book
                    .builder()
                    .id(eBook.getId())
                    .active(eBook.isActive())
                    .author(eBook.getAuthor())
                    .category(eBook.getCategory())
                    .description(eBook.getDescription())
                    .title(eBook.getTitle())
                    .publisher(eBook.getPublisher())
                    .publicationDate(eBook.getPublicationDate())
                    .language(eBook.getLanguage())
                    .numberOfPages(eBook.getNumberOfPages())
                    .format(eBook.getFormat())
                    .isbn(eBook.getIsbn())
                    .shippingWeight(eBook.getShippingWeight())
                    .listPrice(eBook.getListPrice())
                    .ourPrice(eBook.getOurPrice())
                    .inStockNumber(eBook.getInStockNumber())
                    .build();
            return b;
        };
        return mapper;
    }
}
