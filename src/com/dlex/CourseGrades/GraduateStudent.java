package com.dlex.CourseGrades;

public class GraduateStudent extends Student{

    public GraduateStudent(String type, String id, String firstName, String lastName, int[] scores) {
        super(type, id, firstName, lastName, scores);
    }

    @Override
    public String calculateLetterGrade() {
        double average = getTotalScores();
        if (average >= 80) {
            return "S";
        } else {
            return "U";
        }
    }
}
