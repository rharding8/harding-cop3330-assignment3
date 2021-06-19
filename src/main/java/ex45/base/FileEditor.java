/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Harding
 */

package ex45.base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileEditor extends FileIO {
  // Declare vars to hold original file, parent directory, and a String[] for changes
  private final String dir;
  private String[] unsavedFile;

  public FileEditor(String path) {
    // Set Parent Directory to Path
    this.dir = path;
  }

  public void setInputFile(String inputFile) {
    // Set InputFile to file inside of parent directory
    String pathname = String.format("%s/%s", dir, inputFile);
    super.setInputFile(pathname);
  }

  public void setUnsavedFile(String[] unsaved) {
    // Set the unsavedFile (Edit space) to given String[]
    unsavedFile = unsaved;
  }

  public void replaceInFile(String wordToReplace, String replaceWith) {
    // for (every string in unsavedFile)
    //  if (String has wordToReplace)
    //    replace that with replaceWith
    for (int i = 0; i < unsavedFile.length; i++) {
      if (unsavedFile[i].contains(wordToReplace)) {
        unsavedFile[i] = unsavedFile[i].replaceAll(wordToReplace, replaceWith);
      }
    }
  }

  public void writeToFile(String outFile) throws IOException {
    /* Declare and Initialize File object "outputFile" to file named outFile
     * if (file doesn't exist)
     *   Create File
     * Close outputFile
     * Declare and Initialize FileWrite "writer" to file named outputFile
     * for (index 0 through length of unsavedFile)
     *   Write unsavedFile to writer
     *   Add a line break every time
     * Close writer
     * */

    String path = String.format("%s/%s", dir, outFile);
    File outputFile = new File(path);
    while (!outputFile.createNewFile()) {
      //noinspection ResultOfMethodCallIgnored
      outputFile.delete();
    }
    FileWriter writer = new FileWriter(outputFile);
    for (String line: unsavedFile) {
      writer.write(line);
      writer.write(String.format("%n"));
    }
    writer.close();
  }
}
