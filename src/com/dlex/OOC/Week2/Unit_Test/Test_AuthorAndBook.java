package com.dlex.OOC.Week2.Unit_Test;

import com.dlex.OOC.Week2.AuthorAndBook.Author;
import com.dlex.OOC.Week2.AuthorAndBook.Book;
import org.junit.Test;

public class Test_AuthorAndBook {
    @Test
    public void invalidGender() {
        Author anAuthor = new Author("Alexander", "alexander@Google.com", 'k');
        Book aBook = new Book("Java for dummy", anAuthor, 19.95, 1000);
        System.out.println(aBook);
        // Use an anonymous instance of Author
        Book anotherBook = new Book("More Java for dummy", new Author("Solo", "solo@Corp.com", 'j'), 29.95, 888);
        System.out.println(anotherBook);
    }

    @Test
    public void validGender() {
        Author anAuthor = new Author("Alexander", "alexander@Google.com", 'M');
        Book aBook = new Book("Java for dummy", anAuthor, 19.95, 1000);

        // Use an anonymous instance of Author
        Book anotherBook = new Book("More Java for dummy", new Author("Solo", "solo@Corp.com", 'M'), 29.95, 888);
        System.out.println(aBook);
        System.out.println(anotherBook);
        System.out.println(anotherBook.getAuthorName());
        System.out.println(anotherBook.getAuthorEmail());
        System.out.println(anotherBook.getAuthorGender());
    }
}
