package com.dlex.NonCreditCourseGrades;

abstract public class Student {
    private String type;
    private String id;
    private String firstName;
    private String lastName;
    private int[] scores;

    public Student() {
        this.type = "Undefined";
        this.id = "9999999";
        this.firstName = "Unnamed";
        this.lastName = "Unnamed";
        this.scores = new int[3];
    }

    public Student(String type, String id, String firstName, String lastName) {
        this.type = type;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String type, String id, String firstName, String lastName, int[] scores) {
        this.type = type;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.scores = scores;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getScores(int testNumber) {
        return scores[testNumber - 1];
    }

    public boolean setScores(int testNumber, int score) {
        if (score < 0 || score > 100) {
            return false;
        } else {
            scores[testNumber - 1] = score;
            return true;
        }
    }

    protected double getAverageScore() {
        double total = 0;
        for (int score : scores) {
            total += score;
        }
        return total/3;
    }

    abstract String calculateLetterGrade();

    @Override
    public String toString() {
        return "";
    }

}
