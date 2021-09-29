package com.dlex.NonCreditCourseGrades;

public class UndergraduateStudents extends Student {

    public UndergraduateStudents() {
        super();
    }

    public UndergraduateStudents(String type, String id, String firstName, String lastName) {
        super(type, id, firstName, lastName);
    }

    public UndergraduateStudents(String type, String id, String firstName, String lastName, int[] scores) {
        super(type, id, firstName, lastName, scores);
    }

    @Override
    public String calculateLetterGrade() {
        double average = getAverageScore();
        if (average >= 80) {
            return "S";
        } else {
            return "U";
        }
    }
}
