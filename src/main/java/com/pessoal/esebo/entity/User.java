package com.pessoal.esebo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String username;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false, length = 50)
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SaleListing> saleListings;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TradeListing> tradeListings;

    public User() {
    }
    public User(Long id, String username, String email, String password, List<Book> books, List<SaleListing> saleListings, List<TradeListing> tradeListings) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.books = books;
        this.saleListings = saleListings;
        this.tradeListings = tradeListings;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<SaleListing> getSaleListings() {
        return saleListings;
    }

    public void setSaleListings(List<SaleListing> saleListings) {
        this.saleListings = saleListings;
    }

    public List<TradeListing> getTradeListings() {
        return tradeListings;
    }

    public void setTradeListings(List<TradeListing> tradeListings) {
        this.tradeListings = tradeListings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail());
    }
}
