package com.loggar.csv.open_csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadCsvSkippingHeaderLines {
    public static void main(String[] args) {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/csv/users.2.with-header.csv"));

            // create csv reader
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1)
                    .build();

            // read one record at a time
            String[] record;
            while ((record = csvReader.readNext()) != null) {
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
