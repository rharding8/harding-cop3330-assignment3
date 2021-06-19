package ex46.base;

import java.util.Map;
import java.util.Set;

public class Application {
  public static void main(String[] args) {
    // Instantiate Application as app
    // Declare String path to input file
    // Instantiate FileCounter using path
    // Call fillCounts() in FileCounter
    // Call sortCounts() in FileCounter
    // Get Map from getCounts()
    // Pass Map to wordHistogram to print out the histogram
    Application app = new Application();
    String path = "./src/main/java/ex46/base/exercise46_input.txt";
    FileCounter myCounter = new FileCounter(path);
    myCounter.fillCounts();
    myCounter.sortCounts();
    Map<String, Integer> wordMap = myCounter.getCounts();
    app.wordHistogram(wordMap);
  }

  public void wordHistogram(Map<String, Integer> wordMap) {
    // Declare Set based on wordMap's keys
    // for (every key in that set)
    //  print word, then
    //  for (iterate through the count value)
    //    print asterisk
    //  newline

    Set<String> wordSet = wordMap.keySet();

    for (String w: wordSet) {
      System.out.printf("%-10s", w + ": ");
      for (int i = 0; i < wordMap.get(w); i++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
