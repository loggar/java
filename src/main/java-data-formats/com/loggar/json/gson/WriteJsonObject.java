package com.loggar.json.gson;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

public class WriteJsonObject {
    @Test
    public void write() {
        try {
            // create a list of users
            List<UserGson> users = Arrays.asList(new UserGson("John Doe", "john.doe@example.com", new String[] { "Member", "Admin" }, true), new UserGson("Tom Lee", "tom.lee@example.com", new String[] { "Member" }, false));

            // create writer
            Writer writer = new FileWriter("./dist/json/users.3.json");

            // convert users list to JSON file
            new Gson().toJson(users, writer);

            // close writer
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
