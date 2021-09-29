package com.dlex.NonCreditCourseGrades;

 public class GraduateStudent extends Student{

    public GraduateStudent() {
        super();
    }

     public GraduateStudent(String type, String id, String firstName, String lastName) {
         super(type, id, firstName, lastName);
     }

     public GraduateStudent(String type, String id, String firstName, String lastName, int[] scores) {
         super(type, id, firstName, lastName, scores);
     }

     @Override
     public String calculateLetterGrade() {
         double average = getAverageScore();
         if (average >= 90) {
             return "S";
         } else {
             return "U";
         }
     }
 }
