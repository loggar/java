package com.loggar.csv.open_csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ReadCsvCsvToBeanParse {

    public static void main(String[] args) {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/csv/users.2.with-header.csv"));

            // create csv bean reader
            @SuppressWarnings({ "unchecked", "rawtypes" }) CsvToBean<UserCsv> csvToBean = new CsvToBeanBuilder(reader).withType(UserCsv.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // close the reader
            reader.close();

            List<UserCsv> users = csvToBean.parse();

            // iterate through list
            for (UserCsv user : users) {
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
