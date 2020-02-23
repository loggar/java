package com.loggar.csv.core_java;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WriteCsvUsingFileWriter {
    public static void main(String[] args) {
        try {
            // create a list of objects
            List<List<String>> records = Arrays.asList(Arrays.asList("1", "John Lee", "US"), Arrays.asList("2", "Jovan Roover", "DE"), Arrays.asList("3", "Emma Watson", "UK"));

            // create a writer
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("./dist/csv/users-with-header.csv"));

            // write header record
            writer.write("ID,Name,Country");
            writer.newLine();

            // write all records
            for (List<String> record : records) {
                writer.write(String.join(",", record));
                writer.newLine();
            }

            // close the writer
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
