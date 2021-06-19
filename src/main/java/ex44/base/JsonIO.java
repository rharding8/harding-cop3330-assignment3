/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Ryan Harding
 */

package ex44.base;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

public class JsonIO {
  private final Map<String, Object> jsonFile;
  private ArrayList<Map<String, Object>> jsonList;

  public JsonIO(FileReader reader) {
    Gson gson = new Gson();
    jsonFile = gson.fromJson(reader, new TypeToken<Map<String, Object>>() {}.getType());
  }

  @SuppressWarnings("unchecked")
  public void fillJsonList(String field) {
    jsonList = (ArrayList<Map<String, Object>>) jsonFile.get(field);
  }

  public Map<String, Object> findMap(String field, String search) {
    for (Map<String, Object> map: jsonList) {
      if (((String)map.get(field)).equalsIgnoreCase(search)) {
        return map;
      }
    }
    return null;
  }


}
