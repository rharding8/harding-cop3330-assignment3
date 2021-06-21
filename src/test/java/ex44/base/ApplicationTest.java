/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Ryan Harding
 */

package ex44.base;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

  @Test
  void getInfo() {
    String expected = String.format("Name: Vinyl Pressing%nPrice: 20.00%nQuantity: 15");
    Map<String, Object> testMap = new LinkedHashMap<>();
    testMap.put("name", "Vinyl Pressing");
    testMap.put("price", 20.0000);
    testMap.put("quantity", 15.0);
    Application app = new Application();
    String actual = app.getInfo(testMap);
    assertEquals(expected, actual);
  }
}