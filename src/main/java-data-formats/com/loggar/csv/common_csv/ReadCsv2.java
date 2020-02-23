package com.loggar.csv.common_csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ReadCsv2 {
    public static void main(String[] args) {
        // create a reader
        try (Reader reader = Files.newBufferedReader(Paths.get("./dist/csv/users.1.csv"))) {

            // read csv file
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
            for (CSVRecord record : records) {
                System.out.println("Record #: " + record.getRecordNumber());
                System.out.println("ID: " + record.get(0));
                System.out.println("Name: " + record.get(1));
                System.out.println("Email: " + record.get(2));
                System.out.println("Country: " + record.get(3));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
