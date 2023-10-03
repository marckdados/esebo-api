package com.pessoal.esebo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_sales")
public class SaleListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(scale = 13, precision = 2)
    private BigDecimal price;

    public SaleListing() {}

    public SaleListing(Long id, User user, Book book, BigDecimal price) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
