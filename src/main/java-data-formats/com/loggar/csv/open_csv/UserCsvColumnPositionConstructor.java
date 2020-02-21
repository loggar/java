package com.loggar.csv.open_csv;

public class UserCsvColumnPositionConstructor {
    public int id;
    public String name;
    public String email;
    public String countryCode;

    public UserCsvColumnPositionConstructor(int id, String name, String email, String countryCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.countryCode = countryCode;
    }

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
