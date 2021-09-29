package com.dlex.CourseGrades;

public class UndergraduateStudents extends Student {

    public UndergraduateStudents(String type, String id, String firstName, String lastName, int[] scores) {
        super(type, id, firstName, lastName, scores);
    }

    @Override
    public String calculateLetterGrade() {
        double average = getTotalScores();
        if (average >= 85) {
            return "A";
        } else if (average <= 84 && average >= 75) {
            return "B";
        } else if (average <= 74 && average >= 60) {
            return "C";
        } else if (average <= 59 && average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
