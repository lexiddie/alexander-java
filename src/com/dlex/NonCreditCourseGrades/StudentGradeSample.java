package com.dlex.NonCreditCourseGrades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentGradeSample {
    public static void main(String[] args) {
        File savingGrade = new File("NonCreditCourseGrades.CSV");
        ArrayList<Student> students = new ArrayList<>();
        loadStudents(savingGrade, students);
        showStudent(students);
    }
    private static void loadStudents(File savingGrade, ArrayList<Student> students) {
        try {
            Scanner scan = new Scanner(savingGrade);
            while (scan.hasNext()) {
                String type;
                String id;
                String firstname;
                String lastname;
                int[] scores = new int[3];
                String buffer = scan.nextLine();
                StringTokenizer st = new StringTokenizer(buffer);
                type = st.nextToken();
                id = st.nextToken();
                firstname = st.nextToken();
                lastname = st.nextToken();
                scores[0] = Integer.parseInt(st.nextToken());
                scores[1] = Integer.parseInt(st.nextToken());
                scores[2] = Integer.parseInt(st.nextToken());
                if (type.equals("U")) {
                    students.add(new UndergraduateStudents(type, id, firstname, lastname, scores));
                } else {
                    students.add(new GraduateStudent(type, id, firstname, lastname, scores));
                }
            }
            scan.close();
        }catch (FileNotFoundException e) {
            System.err.print("File not found");
        }
    }
    private static void showStudent(ArrayList<Student> students) {
        String labelID = String.format("%-10s", "ID");
        String labelName = String.format("%-10s", "Name");
        String labelType = String.format("%5s", "U/G");
        String labelGrade = String.format("%8s", "Grade");
        String labelT1 = String.format("%4s", "T1");
        String labelT2 = String.format("%4s", "T2");
        String labelT3 = String.format("%4s", "T3");
        System.out.println(labelID + labelName + labelType + labelGrade + labelT1 + labelT2 + labelT3);
        StringBuilder build = new StringBuilder("\n");
        for (Student student : students) {
            String ID = String.format("%-10s", student.getId());
            String Name = String.format("%-10s", student.getFirstName() + " " + student.getLastName());
            String Type = String.format("%5s", student.getType());
            String Grade = String.format("%8s", student.calculateLetterGrade());
            String T1 = String.format("%4s", student.getScores(1));
            String T2 = String.format("%4s", student.getScores(2));
            String T3 = String.format("%4s", student.getScores(3));
            build.append(ID).append(Name).append(Type).append(Grade).append(T1).append(T2).append(T3).append("\n");
        }
        System.out.println(build.toString());
    }
}
