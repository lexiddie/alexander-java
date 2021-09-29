package com.dlex.OOC.Week4.BookAndAuthor;

public class AuthorAndBookDemo {

        public static void main(String[] args) {
        Book book = new Book("Batman", 100.0);
        book.addAuthor(new Author("Lex", "lex@icloud.com", 'M'));
        book.addAuthor(new Author("Solo", "solo@icloud.com", 'M'));
        System.out.println(book.toString());
        System.out.println(book.getAuthors().get(0).toString());
        System.out.println(book.getNumAuthor());
        book.removeAuthorByName("solo");
        System.out.println(book.getNumAuthor());
        System.out.println(book.toString());
    }
}
