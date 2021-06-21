/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Ryan Harding
 */

package ex44.base;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonIOTest {

  @Test
  void findMap_does_exist() {
    try {
      JsonIO myJson = new JsonIO(new FileReader("./src/test/java/ex44/base/testJsonFile.json"));
      myJson.fillJsonList("filmmakers");
      Map<String, Object> expected = new LinkedHashMap<>();
      expected.put("name", "David Fincher");
      expected.put("best film", "Se7en");
      expected.put("worst film", "Alien 3");
      Map<String, Object> actual = myJson.findMap("name", "David Fincher");
      assertEquals(expected, actual);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
      assert false;
    }
  }

  @Test
  void findMap_does_not_exist() {
    try {
      JsonIO myJson = new JsonIO(new FileReader("./src/test/java/ex44/base/testJsonFile.json"));
      myJson.fillJsonList("filmmakers");
      Map<String, Object> actual = myJson.findMap("name", "James Cameron");
      assertNull(actual);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
      assert false;
    }
  }
}