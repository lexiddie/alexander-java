package com.dlex.GolfTournament;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TournamentManager {
    public static void main(String[] args) {
        File savingGolfer = new File("golfers.csv");
        Golfer golfer = new Golfer();
        loadGolfer(golfer, savingGolfer);
        while (true) {
            System.out.println("1/ Add new golfer: ");
            System.out.println("2/ Update a golfer's score: ");
            System.out.println("3/ Display golfer list: ");
            System.out.println("4/ Show the leader board:");
            System.out.println("5/ Exit:");
            Scanner scan = new Scanner(System.in);
            int command = scan.nextInt();
            if (command == 1) {
                boolean check = createNewGolfer(golfer);
                if (!check) {
                    System.out.println("Add Failed");
                }
            } else if (command == 2) {
                boolean check = updateGolfer(golfer);
                if (!check) {
                    System.out.println("Update Failed");
                }
            } else if (command == 3) {
                boolean check = displayGolferList(golfer);
                if (!check) {
                    System.out.println("Display Failed");
                }
            } else if (command == 4) {
                boolean check = showLeaderBoard(golfer);
                if (!check) {
                    System.out.println("Show Failed");
                }
            } else {
                System.out.println("Exit the program");
                saveGolfer(golfer, savingGolfer);
                scan.close();
                return;
            }
        }
    }
    public static void loadGolfer(Golfer golfer, File savingGolfer) {
        try {
            Scanner scan = new Scanner(savingGolfer);
            while (scan.hasNext()) {
                String id;
                String firstname;
                String lastname;
                int[] scores = new int[4];
                String buffer = scan.nextLine();
                StringTokenizer st = new StringTokenizer(buffer);
                id = st.nextToken();
                firstname = st.nextToken();
                lastname = st.nextToken();
                scores[0] = Integer.parseInt(st.nextToken());
                scores[1] = Integer.parseInt(st.nextToken());
                scores[2] = Integer.parseInt(st.nextToken());
                scores[3] = Integer.parseInt(st.nextToken());
                NodeGolfer insert = new NodeGolfer(id, firstname, lastname, scores);
                golfer.insertGolfer(insert);
            }
        }catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
    public static void saveGolfer(Golfer golfer, File savingGolfer) {
        try {
            PrintWriter write = new PrintWriter(savingGolfer);
            NodeGolfer curent = golfer.getHead();
            while (curent != null) {
                String id = String.format("%10s", curent.getId());
                String firstname = String.format("%10s", curent.getFirstname());
                String lastname = String.format("%10s", curent.getLastname());
                String round1 = String.format("%10s", curent.getScore(1));
                String round2 = String.format("%10s", curent.getScore(2));
                String round3 = String.format("%10s", curent.getScore(3));
                String round4 = String.format("%10s", curent.getScore(4));
                String insert = id + firstname + lastname + round1 + round2 + round3 + round4;
                write.println(insert);
                curent = curent.getLink();
            }
            write.close();
        }catch (FileNotFoundException e) {
            System.err.println("File not found");
        }

    }
    public static boolean createNewGolfer(Golfer golfer) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the Golfer ID: ");
        String id = scan.next();
        int check = golfer.find(id);
        if (check != -1) {
            return false;
        }
        System.out.print("Input the firstname: ");
        String firstname = scan.next();
        System.out.print("Input the lastname: ");
        String lastname = scan.next();
        return golfer.insertGolfer(id, firstname, lastname);
    }
    public static boolean updateGolfer(Golfer golfer) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the Golfer ID to update scores: ");
        String id = scan.next();
        int check = golfer.find(id);
        if (check == -1) {
            return false;
        }
        System.out.print("Input round of Golf to update score: ");
        int round = scan.nextInt();
        System.out.print("Input the score to update: ");
        int score = scan.nextInt();
        return golfer.updateScores(round, score);
    }

    public static boolean displayGolferList(Golfer golfer) {
        System.out.println(golfer.toString());
        return true;
    }
    public static boolean showLeaderBoard(Golfer golfer) {
        NodeGolfer[] list = new NodeGolfer[golfer.count()];
        if (golfer.isEmpty()) {
            return false;
        }
        NodeGolfer current = golfer.getHead();
        for (int i = 0; i < golfer.count(); i++) {
            list[i] = current;
            current = current.getLink();
        }
        for (int x = 0; x < list.length; x++) {
            for (int y = 0; y < list.length; y++) {
                if (list[x].getAverageScore() < list[y].getAverageScore()) {
                    NodeGolfer temp = list[x];
                    list[x] = list[y];
                    list[y] = temp;
                }
            }
        }
        for (NodeGolfer nodeGolfer : list) {
            StringBuilder result = new StringBuilder();
            String name = String.format("%5s, %5s", nodeGolfer.getFirstname(), nodeGolfer.getLastname());
            String total = "";
            if (nodeGolfer.getAverageScore() == 0) {
                total = "even";
            } else if (nodeGolfer.getAverageScore() < 0) {
                total = Math.abs(nodeGolfer.getAverageScore()) + " under";
            } else {
                total = Math.abs(nodeGolfer.getAverageScore()) + " over";
            }
            String score = String.format("%15s", total);
            result.append(name).append(score);
            System.out.println(result.toString());
        }
        return true;
    }
}

