/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Harding
 */

package ex43.base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirectoryIO extends FileIO {

  private String parentDir;

  public DirectoryIO(String parentDir) {
    this.parentDir = parentDir;
  }

  public void mkDir(String dirName) {
    // Attempts to create director dirName in parentDir
    // if (succeeds) return good message
    // else (fails) return bad message
    try {
      Files.createDirectories(Paths.get(parentDir + "/" + dirName));
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("FAILED TO CREATE DIRECTORY!");
      return;
    }
    System.out.println("Created " + parentDir + "/" + dirName);
  }

  public void writeToFile(String outFile, String[] fileContents) throws IOException {
    /* Declare and Initialize File object "outputFile" to file named outFile in parentDir
     * if (file doesn't exist)
     *   Create File
     * Close outputFile
     * Declare and Initialize FileWrite "writer" to file named outputFile
     * for (index 0 through length of fileContents)
     *   Write fileContents[index] to writer
     *   Add a line break every time
     * Close writer
     * */
    String path = String.format("%s/%s", parentDir, outFile);
    File outputFile = new File(path);
    while (!outputFile.createNewFile()) {
      //noinspection ResultOfMethodCallIgnored
      outputFile.delete();
    }
    FileWriter writer = new FileWriter(outputFile);
    for (String line: fileContents) {
      writer.write(line);
      writer.write(String.format("%n"));
    }
    writer.close();
  }

  public void setParentDir(String parentDir) {
    // Sets parentDir to given String
    this.parentDir = parentDir;
  }
}
