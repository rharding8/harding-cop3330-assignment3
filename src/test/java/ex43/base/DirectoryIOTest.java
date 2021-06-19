package ex43.base;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryIOTest {

  @Test
  void mkDir() {
    String path = "./src/test/java/ex43/base";
    DirectoryIO myDir = new DirectoryIO(path);
    myDir.mkDir("testDir");
    File myFolder = new File(path + "/testDir");
    assertTrue(myFolder.exists());
  }

  @Test
  void writeToFile() {
    String path = "./src/test/java/ex43/base/testDir";
    DirectoryIO myDir = new DirectoryIO(path);
    String[] original = {"This is a test file", "This is line 2", "This is line 3"};
    String outFile = "testFile.txt";
    try {
      myDir.writeToFile(outFile, original);
    } catch (IOException e) {
      e.printStackTrace();
      assert false;
    }
    File myFile = new File(path + "/testFile.txt");
    assertTrue(myFile.exists());
    FileIO testIO = new FileIO();
    testIO.setInputFile(path + "/testFile.txt");
    String[] actual = new String[0];
    try {
      actual = testIO.readFromFile();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      assert false;
    }
    assertArrayEquals(original, actual);
  }
}