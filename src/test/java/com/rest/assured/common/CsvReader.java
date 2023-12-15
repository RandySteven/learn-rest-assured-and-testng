package com.rest.assured.common;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvReader {

    public static CsvReader getInstance(){
        return new CsvReader();
    }

    private static final String CSV_DELIMITER = ",";

    public ArrayList<String> readCsvUserFile(String file) throws Exception {
        ArrayList<String> datas = new ArrayList<>();
        Scanner scan = new Scanner(new File(file));

        scan.useDelimiter(CSV_DELIMITER);

        while(scan.hasNext()){
            String data = scan.next();
            datas.add(data);
        }

        return datas;
    }

    public Object[][] readCSVData(String csvPath) throws Exception {

        String[][] testData;

        //Get the workbook
        Reader fileInputStream = new FileReader(csvPath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(fileInputStream);


        int numberOfRecords = 0;
        int numberOfColumns = 0;


        for (CSVRecord record : records
        ) {
            System.out.println("Reading record line #" + ++numberOfRecords);
            numberOfColumns = record.size();
        }

        testData = new String[numberOfRecords - 1][numberOfColumns];
        System.out.println("numberOfRecords = " + numberOfRecords);
        System.out.println("numberOfColumns = " + numberOfColumns);


        int currentRecord = 0;


        fileInputStream = new FileReader(csvPath);
        records = CSVFormat.EXCEL.parse(fileInputStream);

        for (CSVRecord record : records
        ) {

            System.out.println("Reading test data ");
            if (record.getRecordNumber() == 1) {
                System.out.println("record = " + record);
                continue;
            }

            for (int i = 0; i < record.size(); i++) {
                testData[currentRecord][i] = record.get(i);

            }
            currentRecord++;
        }
        return testData;
    }


}
