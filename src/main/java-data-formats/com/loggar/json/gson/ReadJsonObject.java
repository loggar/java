package com.loggar.json.gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

public class ReadJsonObject {
    @Test
    public void read() {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/json/user.json"));

            // convert JSON string to User object
            UserGson user = gson.fromJson(reader, UserGson.class);

            // print user object
            System.out.println(user);

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
