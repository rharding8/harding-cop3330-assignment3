package ex41.base;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {

  @Test
  void readFromFile_with_one_line() {
    FileIO myFile = new FileIO();
    myFile.setInputFile("./src/test/java/ex41/base/TestFile1.txt");
    try {
      String[] expected = {"This is a test file with only one line and no breaks whatsoever. Isn't that neat?"};
      String[] actual = myFile.readFromFile();
      assertArrayEquals(expected, actual);
    }
    catch (FileNotFoundException e) {
      assert false;
    }
  }

  @Test
  void readFromFile_with_multiple_lines() {
    FileIO myFile = new FileIO();
    myFile.setInputFile("./src/test/java/ex41/base/TestFile2.txt");
    try {
      String[] expected = {"This is a test file with multiple lines! To fill up space, here's the opening of Batman v Superman:",
              "...", "There was a time above, a time before...", "There were perfect things, diamond absolutes.",
              "But things fall, things on Earth...", "And what falls, is fallen.", "...",
              "In the dream, they took me to the light.", "A beautiful lie."};
      String[] actual = myFile.readFromFile();
      assertArrayEquals(expected, actual);
    }
    catch (FileNotFoundException e) {
      assert false;
    }
  }

  @Test
  void readFromFile_that_does_not_exist() {
    FileIO myFile = new FileIO();
    myFile.setInputFile("./src/test/java/ex41/base/TestFile3.txt");
    try {
      String[] expected = {"This file doesn't exist, so who cares?"};
      String[] actual = myFile.readFromFile();
      assertArrayEquals(expected, actual);
    }
    catch (FileNotFoundException e) {
      assert true;
    }
  }

  @Test
  void writeToFile_short_file() {
    FileIO myFile = new FileIO();
    String[] original = {"Holy Wars...", "The Punishment Due!"};
    String outputPath = "./src/test/java/ex41/base/OutputTest1.txt";
    try {
      myFile.writeToFile("Test Output File 1: ", outputPath, original);
      File output = new File(outputPath);
      assertTrue(output.exists());
      String[] expected = {"Test Output File 1: ", "-------------------", "Holy Wars...", "The Punishment Due!"};
      myFile.setInputFile(outputPath);
      assertArrayEquals(expected, myFile.readFromFile());
    }
    catch (IOException e) {
      assert false;
    }
  }

  @Test
  void writeToFile_long_file() {
    FileIO myFile = new FileIO();
    String[] original = {"This song is a", "Poem to Myself", "Helps me to Live!",
            "In case of fire,", "Break! The glass", "And move on into your own!"};
    String outputPath = "./src/test/java/ex41/base/OutputTest2.txt";
    try {
      myFile.writeToFile("Test Output File 2: ", outputPath, original);
      File output = new File(outputPath);
      assertTrue(output.exists());
      String[] expected = {"Test Output File 2: ", "-------------------",
              "This song is a", "Poem to Myself", "Helps me to Live!",
              "In case of fire,", "Break! The glass", "And move on into your own!"};
      myFile.setInputFile(outputPath);
      assertArrayEquals(expected, myFile.readFromFile());
    }
    catch (IOException e) {
      assert false;
    }
  }
}