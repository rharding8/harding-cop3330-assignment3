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
  // Declare Map to hold the word counts
  // Declare a File to hold the input file
  private Map<String, Integer> counts = new LinkedHashMap<>();
  private final File inputFile;

  public FileCounter(String path) {
    // Set inputFile to the file given by the path
    inputFile = new File(path);
  }

  public void fillCounts() {
    try {
      // Create a scanner to read the inputFile
      // while (Next word exists)
      //  put the String in a temp variable
      //  merge that temp variable into counts, or add it if it doesn't exist
      // Close reader
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
    // Create new Map to hold sorted values
    // Use the stream function to put descending order entries into the new map
    // Set the old map to the new map
    Map<String, Integer> sortedMap = new LinkedHashMap<>();
    counts.entrySet().
            stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
            forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
    counts = sortedMap;
  }

  public Map<String, Integer> getCounts() {
    // Return counts map
    return counts;
  }
}
