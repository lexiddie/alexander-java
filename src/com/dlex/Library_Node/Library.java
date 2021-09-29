package com.dlex.Library_Node;

public class Library {
    private final String name;
    private LinkedList list;

    public Library(String name) {
        this.name = name;
    }

    public void printMenu() {
        System.out.println("Welcome to " + this.name);
        System.out.println("1. List items");
        System.out.println("2. Search item");
        System.out.println("3. Add book");
        System.out.println("4. Add DVD");
        System.out.println("5. Borrow item");
        System.out.println("6. Return item");
        System.out.println("7. Exit");
    }

    public void listItems() {
        int result = list.count();
        if (result == 0) {
            System.out.println("The list is empty");
        } else {
            System.out.println("We have " + result + " of lists");
        }
    }

    public void searchItem(int id) {
        int check = list.findID(id);
        if (check != -1) {
            System.out.println("This id has item");
        } else {
            System.out.println("This id is not exits");
        }
    }

    public void insertBook() {
        Book book = new Book(232, "Tell no tales");
        book.setPageCount(50);
        list.insertBook(book);
    }

    public void insertDVD() {
        DVD dvd = new DVD(233, "Iron Man");
        dvd.setDuration(230);
        list.insertBook(dvd);
    }
}
