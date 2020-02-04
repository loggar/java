package com.loggar.datetimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatting {
    public static void main(String[] args) {
        LocalDateTime input = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
        String date = input.format(format);
        String logFile = "simple-log-" + date + ".txt";

        System.out.println(logFile);
        System.out.println(
                LocalDateTime.now()
                        .format(DateTimeFormatter.BASIC_ISO_DATE)
        );

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.println(format2.format(LocalDate.of(2016, 7, 31)));
        System.out.println(
                LocalDateTime.now()
                        .format(format2)
        );
    }
}
