package com.dlex.OOC.Week12.PopularLastName;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

class PopularLastName {

    private final ArrayList<Popular> populars = new ArrayList<>();

    void ReadFile(String fileLocation, String outputDirectory) {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new File(fileLocation));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            int totalSheet = sheet.getPhysicalNumberOfRows();

            for (int i = 2; i < totalSheet; i++) {
                HSSFRow row = sheet.getRow(i);
                java.lang.String name = "";
                int rank = 0;
                for (int j = 0; j < 2; j++) {
                    if (j == 0) {
                        name = row.getCell(j).getStringCellValue();
                    } else {
                        rank = (int)Math.round(row.getCell(j).getNumericCellValue());
                    }
                }
                Popular popular = new Popular(name, rank);
                populars.add(popular);
            }
        } catch(Exception ioe) {
            ioe.printStackTrace();
        }

        for (Popular i: populars) {
            System.out.println(i.getName() + " " + i.getRank());
        }

        String data = appendData(populars);
        writeFile(data, outputDirectory);
    }


    private String appendData(ArrayList<Popular> populars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Popular i: populars) {
            System.out.println(i.getName() + " " + i.getRank());
            stringBuilder.append(i.getName()).append("\n");
        }
        return stringBuilder.toString();
    }

    private void writeFile (String data, String directory) {
        Writer fWriter;
        String slash = File.separator;
        String fileName ="popularName.in";
        try {
            fWriter = new FileWriter(directory + slash + fileName);
            fWriter.write(data);
            fWriter.flush();
            fWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String searchByRank(int rank) {
        try {
            return populars.get(rank - 1).getName();
        } catch (Exception e) {
            e.printStackTrace();
            return "Not Found";
        }
    }

    public int searchByName(String name) {
        for (Popular popular: populars) {
            if (popular.getName().toLowerCase().equalsIgnoreCase(name.toLowerCase())) {
                return popular.getRank();
            }
        }
        return -1;
    }

    public boolean checkData() {
        return this.populars.isEmpty();
    }

}
