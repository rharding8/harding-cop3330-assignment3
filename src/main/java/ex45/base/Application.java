package ex45.base;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Application {
  // Declare Scanner to read input
  Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    // Instantiate Application as app
    // Set Strings to hold paths and input file name
    // Call readName() and set to String
    // Instantiate FileEditor as editor
    // Collect contents of inputFile into a String[]
    // set that String[] into editor
    // Call replaceInFile() in editor using utilize and use
    // Call writeToFile() in editor to create the output
    Application app = new Application();
    String parentDir = "./src/main/java/ex45/base";
    String inputFile = "exercise45_input.txt";
    String outputFile = app.readName();
    FileEditor editor = new FileEditor(parentDir);
    editor.setInputFile(inputFile);
    String[] workingFile = new String[0];
    try {
      workingFile = editor.readFromFile();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    editor.setUnsavedFile(workingFile);
    editor.replaceInFile("utilize", "use");
    try {
      editor.writeToFile(outputFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String readName() {
    // Prompt for output file name
    // Return answer

    System.out.print("What filename would you like to output to? ");
    return input.nextLine();
  }
}
