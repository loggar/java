package com.loggar.csv.common_csv;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class WriteCsvFromList {
    public static void main(String[] args) {
        try {
            // create a writer
            Writer writer = Files.newBufferedWriter(Paths.get("./dist/csv/students.csv"));

            // write CSV file
            CSVPrinter printer = CSVFormat.DEFAULT.withHeader("ID", "Name", "Program", "University")
                    .print(writer);

            // create a list
            List<Object[]> data = new ArrayList<>();
            data.add(new Object[] { 1, "John Mike", "Engineering", "MIT" });
            data.add(new Object[] { 2, "Jovan Krovoski", "Medical", "Harvard" });
            data.add(new Object[] { 3, "Lando Mata", "Computer Science", "TU Berlin" });
            data.add(new Object[] { 4, "Emma Ali", "Mathematics", "Oxford" });

            // write list to file
            printer.printRecords(data);

            // flush the stream
            printer.flush();

            // close the writer
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
