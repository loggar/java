package com.loggar.csv.open_csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ReadCsvUsingAnnotations {

    public static void main(String[] args) {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/csv/users.2.with-header.csv"));

            // create csv bean reader
            @SuppressWarnings({ "unchecked", "rawtypes" }) CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(UserCsv.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // close the reader
            reader.close();

            // iterate through users
            for (@SuppressWarnings("unchecked") UserCsv user : (Iterable<UserCsv>) csvToBean) {
                System.out.println("ID: " + user.getId());
                System.out.println("Name: " + user.getName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Country: " + user.getCountryCode());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
