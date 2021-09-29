package com.dlex.OOC.Week6.KML;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KML {

    void ReadFile(String fileLocation, String outputDirectory) {
        ArrayList<String> coordinates = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileLocation));
            while (scanner.hasNext()) {
                coordinates.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        convention(coordinates, outputDirectory);
    }

    private void convention(ArrayList<String> coordinates, String outputDirectory) {
        StringBuilder sb = new StringBuilder();
        sb.append(generateHeader());
        sb.append(generateBody(coordinates));
        sb.append(generateFooter());
        System.out.println(sb.toString());
        writeFile(sb.toString(), outputDirectory);
    }

    private String generateHeader() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<kml xmlns=\"http://earth.google.com/kml/2.1\">\n" +
                "<Document>\n" +
                "\t<name>" + "Mystery Locations" + "</name>\n";
    }

    private String generateBody(ArrayList<String> coordinates) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String i : coordinates) {
            count += 1;
            String longitude = i.split(" ")[0];
            String latitude = i.split(" ")[1];
            String kmlPlaceMark1 = "\t<Placemark>\n" + "\t\t<name>Location " + count + " </name>\n";
            String kmlPlaceMark2 = "\t\t<Point>\n" + "\t\t\t<coordinates>" + longitude + "," + latitude + ",0"+
                    "</coordinates>\n" + "\t\t</Point>\n";
            String kmlPlaceMark3 = "\t</Placemark>";
            sb.append(kmlPlaceMark1).append(kmlPlaceMark2).append(kmlPlaceMark3);
        }
        return sb.toString();
    }

    private String generateFooter() {
        return "\n</Document>" + "\n</kml>";
    }

    private void writeFile (String data, String directory) {
        System.out.println("Checking directory");
        System.out.println(directory);
        Writer fWriter;
        String slash = File.separator;
        String fileName ="googleEarth.kml";
        try {
            fWriter = new FileWriter(directory + slash + fileName);
            fWriter.write(data);
            fWriter.flush();
            fWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
