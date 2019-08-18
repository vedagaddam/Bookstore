package com.bookstore.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class EBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
