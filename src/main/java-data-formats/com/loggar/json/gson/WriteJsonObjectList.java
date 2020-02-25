package com.loggar.json.gson;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.google.gson.Gson;

public class WriteJsonObjectList {
    @Test
    public void write() {
        try {
            // create user object
            UserGson user = new UserGson("John Doe", "john.doe@example.com", new String[] { "Member", "Admin" }, true);

            // create Gson instance
            Gson gson = new Gson();

            // create a writer
            Writer writer = Files.newBufferedWriter(Paths.get("./dist/json/user.2.json"));

            // convert user object to JSON file
            gson.toJson(user, writer);

            // close writer
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
