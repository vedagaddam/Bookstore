package com.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private String language;
    private String category;
    private int numberOfPages;
    private String format;
    private Integer isbn;
    private double shippingWeight;
    private double listPrice;
    private double ourPrice;
    private boolean active = true;
    private String description;
    private int inStockNumber;
}
