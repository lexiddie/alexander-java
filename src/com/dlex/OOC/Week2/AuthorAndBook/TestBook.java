package com.dlex.OOC.Week2.AuthorAndBook;

public class TestBook {
    public static void main(String[] args) {
        Author anAuthor = new Author("Alexander", "alexander@Google.com", 'M');
        Book aBook = new Book("Java for dummy", anAuthor, 19.95, 1000);

        // Use an anonymous instance of Author
        Book anotherBook = new Book("More Java for dummy", new Author("Solo", "solo@Corp.com", 'M'), 29.95, 888);

        System.out.println(aBook.getAuthor().toString());
        System.out.println(anotherBook.getAuthor().toString());

        System.out.println(anotherBook.getAuthorName());
        System.out.println(anotherBook.getAuthorEmail());
        System.out.println(anotherBook.getAuthorGender());
    }
}
