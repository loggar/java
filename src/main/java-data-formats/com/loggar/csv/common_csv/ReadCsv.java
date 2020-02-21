package com.loggar.csv.common_csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ReadCsv {
    public static void main(String[] args) {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/csv/users.1.csv"));

            // read csv file
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);

            // Alternatively, you can also use getRecords() method from the CSVParser class to read all the records at once into memory:
            // read all records into memory
            // List<CSVRecord> records = CSVFormat.DEFAULT.parse(reader).getRecords();

            for (CSVRecord record : records) {
                System.out.println("Record #: " + record.getRecordNumber());
                System.out.println("ID: " + record.get(0));
                System.out.println("Name: " + record.get(1));
                System.out.println("Email: " + record.get(2));
                System.out.println("Country: " + record.get(3));
            }

            // close the reader
            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
