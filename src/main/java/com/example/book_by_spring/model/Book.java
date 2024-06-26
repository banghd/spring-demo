package com.example.book_by_spring.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    private float price;
    private String author;
    private int amount;


    public Book(){}

    public float getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
