package com.loggar.json.gson;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class WriteJsonMap {
    @Test
    public void write() {
        try {
            // create a map
            Map<String, Object> map = new HashMap<>();
            map.put("name", "John Deo");
            map.put("email", "john.doe@example.com");
            map.put("roles", new String[] { "Member", "Admin" });
            map.put("admin", true);

            // create a writer
            Writer writer = new FileWriter("./dist/json/user.2.json");

            // convert map to JSON File
            new Gson().toJson(map, writer);

            // close the writer
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
