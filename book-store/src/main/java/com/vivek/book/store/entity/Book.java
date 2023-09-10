package com.vivek.book.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private String genre;
    private List<String> imageDetails = new ArrayList<>();
    private double price;
    private int pageCount;
    private boolean isNew;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
