package com.loggar.json.gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReadJsonFile2 {
    @Test
    public void read() {
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/json/customer.json"));

            // create JsonObject instance
            JsonObject parser = JsonParser.parseReader(reader)
                    .getAsJsonObject();

            // read customer details
            System.out.println(
                    parser.get("id")
                            .getAsLong()
            );
            System.out.println(
                    parser.get("name")
                            .getAsString()
            );
            System.out.println(
                    parser.get("email")
                            .getAsString()
            );
            System.out.println(
                    parser.get("age")
                            .getAsLong()
            );

            // read address
            JsonObject address = parser.get("address")
                    .getAsJsonObject();
            System.out.println(
                    address.get("street")
                            .getAsString()
            );
            System.out.println(
                    address.get("city")
                            .getAsString()
            );
            System.out.println(
                    address.get("state")
                            .getAsString()
            );
            System.out.println(
                    address.get("zipCode")
                            .getAsLong()
            );

            // read payment method
            for (
                JsonElement pm : parser.get("paymentMethods")
                        .getAsJsonArray()
            ) {
                System.out.println(pm.getAsString());
            }

            // read projects
            for (
                JsonElement project : parser.get("projects")
                        .getAsJsonArray()
            ) {
                JsonObject obj = project.getAsJsonObject();
                System.out.println(
                        obj.get("title")
                                .getAsString()
                );
                System.out.println(
                        obj.get("budget")
                                .getAsLong()
                );
            }

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
