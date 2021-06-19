package ex46.base;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileCounterTest {

  @Test
  void getCounts_base_unsorted() {
    Map<String, Integer> expectedMap = new LinkedHashMap<>();
    expectedMap.put("wake", 3);
    expectedMap.put("me", 2);
    expectedMap.put("up", 4);
    expectedMap.put("inside", 1);
    FileCounter counter = new FileCounter("./src/test/java/ex46/base/TestInput1.txt");
    counter.fillCounts();
    Map<String, Integer> actualMap = counter.getCounts();
    assertEquals(expectedMap, actualMap);
  }

  @Test
  void getCounts_sorted_test1() {
    Map<String, Integer> expectedMap = new LinkedHashMap<>();
    expectedMap.put("up", 4);
    expectedMap.put("wake", 3);
    expectedMap.put("me", 2);
    expectedMap.put("inside", 1);
    FileCounter counter = new FileCounter("./src/test/java/ex46/base/TestInput1.txt");
    counter.fillCounts();
    counter.sortCounts();
    Map<String, Integer> actualMap = counter.getCounts();
    assertEquals(expectedMap, actualMap);
  }

  @Test
  void getCounts_sorted_test2() {
    Map<String, Integer> expectedMap = new LinkedHashMap<>();
    expectedMap.put("it", 11);
    expectedMap.put("shoot", 6);
    expectedMap.put("want", 5);
    expectedMap.put("out", 3);
    expectedMap.put("cause", 3);
    expectedMap.put("I", 3);
    expectedMap.put("now", 3);
    expectedMap.put("a", 1);
    expectedMap.put("little", 1);
    expectedMap.put("more", 1);
    expectedMap.put("you", 1);
    expectedMap.put("can", 1);
    expectedMap.put("be", 1);
    expectedMap.put("rest", 1);
    expectedMap.put("assured", 1);
    FileCounter counter = new FileCounter("./src/test/java/ex46/base/TestInput2.txt");
    counter.fillCounts();
    counter.sortCounts();
    Map<String, Integer> actualMap = counter.getCounts();
    assertEquals(expectedMap, actualMap);
  }
}