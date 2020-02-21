package com.loggar.csv.open_csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCsvAtOnce {
    public static void main(String[] args) {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/csv/users.1.csv"));

            // create csv reader
            CSVReader csvReader = new CSVReader(reader);

            // read all records at once
            List<String[]> records = csvReader.readAll();

            // iterate through list of records
            for (String[] record : records) {
                System.out.println("ID: " + record[0]);
                System.out.println("Name: " + record[1]);
                System.out.println("Email: " + record[2]);
                System.out.println("Country: " + record[3]);
            }

            // close readers
            csvReader.close();
            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
