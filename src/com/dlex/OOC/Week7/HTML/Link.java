package com.dlex.OOC.Week7.HTML;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Link {

    void ReadFile(String fileLocation, String outputDirectory, boolean check) {
        StringBuilder sb = new StringBuilder();
        ArrayList<WebLink> links = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileLocation));
            while (scanner.hasNext()) {
                String buffer = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(buffer);
                while (st.hasMoreTokens()) {
                    String data = st.nextToken();
                    if (data.length() > 4 && data.substring(0,5).equals("href=")) {
                        String value = data.split("=")[1];
                        String link = value.substring(1, value.lastIndexOf("\""));
                        System.out.println(link);
                        sb.append(link).append("\n");
                        links.add(new WebLink(link));
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writeFile(sb.toString(), outputDirectory);
        if (check) {
            insertLink(links);
        }
    }

    private void writeFile (String data, String directory) {
        Writer fWriter;
        String slash = File.separator;
        String fileName ="links.in";
        try {
            fWriter = new FileWriter(directory + slash + fileName);
            fWriter.write(data);
            fWriter.flush();
            fWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    void insertLink(List<WebLink> links) {

        String SQL = "INSERT INTO tbl_link(link) " + "VALUES(?)";

        try {
            Connection conn = connect();

            PreparedStatement statement = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            int count = 0;

            for (WebLink link : links) {
                statement.setString(1, link.getLink());
                statement.addBatch();
                count++;
                if (count % 100 == 0 || count == links.size()) {
                    statement.executeBatch();
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
