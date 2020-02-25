package com.loggar.json.gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

public class ReadJsonMap {
    @Test
    public void read() {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("./dist/json/user.json"));

            // convert JSON file to map
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            // print map entries
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
