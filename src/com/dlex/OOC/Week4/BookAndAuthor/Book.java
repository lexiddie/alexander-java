package com.dlex.OOC.Week4.BookAndAuthor;

import java.util.ArrayList;

public class Book {

    private final String name;
    private final ArrayList<Author> authors = new ArrayList<>();
    private int numAuthor = 0;
    private Double price;
    private int qtyInStock;

    public Book(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Book(String name, Double price, int qtyInStock) {
        this.name = name;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
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

    public int getNumAuthor() {
        return numAuthor;
    }

    public void printAuthors() {
        for (Author a : this.authors) {
            System.out.println(a.toString());
        }
    }

    public void addAuthor(Author author) {
        this.numAuthor += 1;
        this.authors.add(author);
    }

    public boolean removeAuthorByName(String authorName) {
        for (int i = 0; i < this.authors.size(); i++) {
            if (this.authors.get(i).getName().toLowerCase().equals(authorName.toLowerCase())) {
                this.numAuthor -= 1;
                this.authors.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.authors.size() > 1) {
            return this.name + " by " + this.authors.get(0).toString() + " at all";
        }
        return this.name + " by " + this.authors.get(0).toString();
    }
}
