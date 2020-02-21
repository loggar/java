package com.loggar.csv.open_csv;

import com.opencsv.bean.CsvBindByPosition;

public class UserCsvBindByPosition {
    @CsvBindByPosition(position = 0) public int id;
    @CsvBindByPosition(position = 1) public String name;
    @CsvBindByPosition(position = 2) public String email;
    @CsvBindByPosition(position = 3) public String countryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserCsv [id=")
                .append(id)
                .append(", name=")
                .append(name)
                .append(", email=")
                .append(email)
                .append(", countryCode=")
                .append(countryCode)
                .append("]");
        return builder.toString();
    }

}
