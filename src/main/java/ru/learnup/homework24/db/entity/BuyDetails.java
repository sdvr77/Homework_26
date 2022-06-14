package ru.learnup.homework24.db.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class BuyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private int price;

    @Column
    private int amount;

    @OneToOne
    @JoinColumn(name = "buy_id")
    private Buy buy;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private List<Book> books;

    public BuyDetails() {
    }

    public BuyDetails(int price, int amount, Buy buy, List<Book> books) {
        this.price = price;
        this.amount = amount;
        this.buy = buy;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Buy getBuy() {
        return buy;
    }

    public void setBuy(Buy buy) {
        this.buy = buy;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
