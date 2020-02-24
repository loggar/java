package com.loggar.json.json_simple;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJson {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", 100);

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try (
                FileWriter file = new FileWriter(
                        Paths.get("./dist/json/customer.json")
                                .toFile()
                )
        ) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }
}
