package com.loggar.csv.open_csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ReadCsvUsingAnnotationBindByPosition {
    /*
     * If the CSV file does not have a header, you use the @CsvBindByPosition annotation to map the column position (zero-based) to bean fields like below:
     * 
     */
    public static void main(String[] args) {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/csv/users.1.csv"));

            // create csv bean reader
            @SuppressWarnings({ "unchecked", "rawtypes" }) CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(UserCsvBindByPosition.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // close the reader
            reader.close();

            // iterate through users
            for (@SuppressWarnings("unchecked") UserCsvBindByPosition user : (Iterable<UserCsvBindByPosition>) csvToBean) {
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
