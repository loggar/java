package com.loggar.json.gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ReadJsonObjectList {
    @Test
    public void read() {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/json/users.json"));

            // convert JSON array to list of users
            List<UserGson> users = gson.fromJson(reader, new TypeToken<List<UserGson>>() {
            }.getType());

            // print users
            users.forEach(System.out::println);

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
