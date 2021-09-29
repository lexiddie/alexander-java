package com.dlex.OOC.Week4.BookAndAuthor;

public class Author {

    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) throws ArithmeticException {
        if (!isValidGender(gender)) {
            throw new ArithmeticException("Invalid gender!");
        }
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    private boolean isValidGender(char gender) {
        return gender == 'm' || gender == 'f' || gender == 'M' || gender == 'F';
    }

    @Override
    public String toString() {
        return this.name + " (" + this.gender + ") at " + this.email;
    }
}
