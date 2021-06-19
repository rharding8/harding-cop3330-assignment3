/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Harding
 */

package ex46.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FileCounter {
  private Map<String, Integer> counts = new LinkedHashMap<>();
  private final File inputFile;

  public FileCounter(String path) {
    inputFile = new File(path);
  }

  public void fillCounts() {
    try {
      Scanner reader = new Scanner(inputFile);
      while (reader.hasNext()) {
        String temp = reader.next();
        counts.merge(temp, 1, Integer::sum);
      }
      reader.close();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void sortCounts() {
    Map<String, Integer> sortedMap = new LinkedHashMap<>();
    counts.entrySet().
            stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
            forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
    counts = sortedMap;
  }

  public Map<String, Integer> getCounts() {
    return counts;
  }
}
