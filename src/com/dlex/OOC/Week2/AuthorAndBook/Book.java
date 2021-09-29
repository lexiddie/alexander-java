package com.dlex.OOC.Week2.AuthorAndBook;

public class Book {

    private String name;
    private Author author;
    private Double price;
    private int qtyInStock;

    public Book(String name, Author author, Double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String name, Author author, Double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    private void setAuthor(Author author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public String getAuthorName() {
        return this.author.getName();
    }

    public String getAuthorEmail() {
        return this.author.getEmail();
    }

    public char getAuthorGender() {
        return this.author.getGender();
    }

    @Override
    public String toString() {
        return this.name + " by" + this.author.toString();
    }
}
