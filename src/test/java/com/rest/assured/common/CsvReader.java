package com.rest.assured.common;

import java.io.File;
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

}
