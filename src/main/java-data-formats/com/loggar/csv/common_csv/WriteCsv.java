package com.loggar.csv.common_csv;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class WriteCsv {
    public static void main(String[] args) {
        try {
            // create a writer
            Writer writer = Files.newBufferedWriter(Paths.get("./dist/csv/students.csv"));

            // write CSV file
            CSVPrinter printer = CSVFormat.DEFAULT.withHeader("ID", "Name", "Program", "University")
                    .print(writer);

            printer.printRecord(1, "John Mike", "Engineering", "MIT");
            printer.printRecord(2, "Jovan Krovoski", "Medical", "Harvard");
            printer.printRecord(3, "Lando Mata", "Computer Science", "TU Berlin");
            printer.printRecord(4, "Emma Ali", "Mathematics", "Oxford");

            // flush the stream
            printer.flush();

            // close the writer
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
