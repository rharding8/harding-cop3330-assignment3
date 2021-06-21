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

  // Declare Map for the JsonFile at the top level
  private final Map<String, Object> jsonFile;
  // Declare list of Maps for an array in the jsonFile
  private ArrayList<Map<String, Object>> jsonList;

  public JsonIO(FileReader reader) {
    // Use gson and the fromJson() function to set jsonFile to given FileReader
    Gson gson = new Gson();
    jsonFile = gson.fromJson(reader, new TypeToken<Map<String, Object>>() {}.getType());
  }

  @SuppressWarnings("unchecked")
  public void fillJsonList(String field) {
    // Fill the List of Maps with the array given by the field sent to method
    jsonList = (ArrayList<Map<String, Object>>) jsonFile.get(field);
  }

  public Map<String, Object> findMap(String field, String search) {
    // for (every map in jsonList)
    //  if (element at map according to key field equals the search string)
    //    return that specific map
    // return null if none found
    for (Map<String, Object> map: jsonList) {
      if (((String)map.get(field)).equalsIgnoreCase(search)) {
        return map;
      }
    }
    return null;
  }


}
