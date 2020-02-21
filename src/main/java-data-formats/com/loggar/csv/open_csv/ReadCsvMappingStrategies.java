package com.loggar.csv.open_csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ReadCsvMappingStrategies {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/csv/users.2.with-header.csv"));

            // columns name
            String[] columns = { "id", "name", "email", "countryCode" };

            // create a mapping strategy
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(UserCsvColumnPositionConstructor.class);
            strategy.setColumnMapping(columns);

            // create csv bean reader
            CsvToBean csvToBean = new CsvToBeanBuilder(reader).withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // close the reader
            reader.close();

            // iterate through users
            for (UserCsvColumnPositionConstructor user : (Iterable<UserCsvColumnPositionConstructor>) csvToBean) {
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
