/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Ryan Harding
 */

package ex45.base;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileEditorTest {

  @Test
  void replaceInFile() {
    String path = "./src/test/java/ex45/base";
    FileEditor editor = new FileEditor(path);
    String[] unsaved = {"You gotta replace this with that", "Cause this is actually that", "And this is a fact"};
    String[] expected = {"You gotta replace that with that", "Cause that is actually that", "And that is a fact"};
    editor.setUnsavedFile(unsaved);
    editor.replaceInFile("this", "that");
    try {
      editor.writeToFile("testFile.txt");
      editor.setInputFile("testFile.txt");
      String[] actual = editor.readFromFile();
      assertArrayEquals(expected, actual);
    }
    catch (IOException e) {
      e.printStackTrace();
      assert false;
    }
  }
}