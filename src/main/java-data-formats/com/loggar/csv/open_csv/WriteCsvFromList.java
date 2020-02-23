package com.loggar.csv.open_csv;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class WriteCsvFromList {
    public static void main(String[] args) {
        try {
            // create a write
            Writer writer = Files.newBufferedWriter(Paths.get("users-objects.csv"));

            // create a csv writer
            StatefulBeanToCsv<UserCsvColumnPositionConstructor> csvWriter = new StatefulBeanToCsvBuilder<UserCsvColumnPositionConstructor>(writer).withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                    .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                    .withOrderedResults(false)
                    .build();

            // create a list of objects (`User`)
            List<UserCsvColumnPositionConstructor> users = new ArrayList<>();
            users.add(new UserCsvColumnPositionConstructor(1, "Emma Watson", "emma.watson@example.com", "UK"));
            users.add(new UserCsvColumnPositionConstructor(2, "Nick Jones", "nick.jones@example.com", "DE"));
            users.add(new UserCsvColumnPositionConstructor(3, "Shanzay Alai", "shanzay.alai@example.com", "US"));

            // write list of objects
            try {
                csvWriter.write(users);
            } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
                e.printStackTrace();
            }

            // close the writer
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
