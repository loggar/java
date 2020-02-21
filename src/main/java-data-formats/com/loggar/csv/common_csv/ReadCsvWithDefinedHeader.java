package com.loggar.csv.common_csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ReadCsvWithDefinedHeader {
    public static void main(String[] args) {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/csv/users.1.csv"));

            // read csv file
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("ID", "Name", "Email", "Country")
                    .parse(reader);
            for (CSVRecord record : records) {
                System.out.println("Record #: " + record.getRecordNumber());
                System.out.println("ID: " + record.get("ID"));
                System.out.println("Name: " + record.get("Name"));
                System.out.println("Email: " + record.get("Email"));
                System.out.println("Country: " + record.get("Country"));
            }

            // close the reader
            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
