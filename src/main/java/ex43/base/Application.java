/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Harding
 */

package ex43.base;

import java.io.IOException;
import java.util.Scanner;

public class Application {
  // Same as before, the basic actions are all called here

  // Declare and initialize Scanner variable for use in class here
  Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    // Declare String "workingDir" as path to the website directory
    // Declare String "webName" as output of a Call to readName()
    // Declare and Initialize Object of DirectoryIO "myDir" to the parent directory of workingDir
    // Declare String "author" as output of call to readAuthor()
    // Call mkDir() in myDir using webName
    // Call setParentDir() in myDir to webName
    // Declare String Array "htmlContents" to output of craftHTML()
    // Call writeToFile in myDir using htmlContents and outputting to "index.html"
    // if (return value of call to makeJS())
    //  Call mkDir() in myDir to create a "js" folder
    // if (return value of call to makeCSS())
    //  Call mkDir() in myDir to create a "css" folder
    Application app = new Application();
    String workingDir = "./src/main/java/ex43/base/website";
    String webName = app.readName();
    String author = app.readAuthor();
    boolean js = app.makeJS();
    boolean css = app.makeCSS();
    DirectoryIO myDir = new DirectoryIO(workingDir);
    myDir.mkDir(webName);
    myDir.setParentDir(workingDir + "/" + webName);
    String[] htmlContents = app.craftHTML(webName, author);
    try {
      myDir.writeToFile("index.html", htmlContents);
      System.out.println("Created " + workingDir + "/" + webName +"/index.html");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("FAILED TO WRITE FILE 'index.html'");
    }
    if (js) {
      myDir.mkDir("js");
    }
    if (css) {
      myDir.mkDir("css");
    }
  }

  public String readName() {
    // Read website name from input
    System.out.print("Site Name: ");
    return input.nextLine();
  }

  public String readAuthor() {
    // Read author name from input
    System.out.print("Author: ");
    return input.nextLine();
  }

  public boolean makeJS() {
    // Read if user wants to create a js folder from input
    while (true) {
      System.out.print("Do you want a folder for JavaScript (y/n)? ");
      String ans = input.nextLine();
      if (ans.equalsIgnoreCase("y")) {
        return true;
      }
      if (ans.equalsIgnoreCase("n")) {
        return false;
      }
      System.out.print("Sorry, that didn't come out right. Can you try again? ");
    }
  }

  public boolean makeCSS() {
    // Read if user wants to create a css folder from input
    while (true) {
      System.out.print("Do you want a folder for CSS (y/n)? ");
      String ans = input.nextLine();
      if (ans.equalsIgnoreCase("y")) {
        return true;
      }
      if (ans.equalsIgnoreCase("n")) {
        return false;
      }
      System.out.print("Sorry, that didn't come out right. Can you try again? ");
    }
  }

  public String[] craftHTML(String webName, String authName) {
    // Declare a 4 cell String Array "htmlFile"
    // Set indexes 0 and 3 to the required tags
    // Set index 1 to title tag and webName
    // Set index 2 to meta tag and authName
    // Return htmlFile
    String[] htmlFile = new String[4];
    htmlFile[0] = "<html>";
    htmlFile[1] = "<title> " + webName + " </title>";
    htmlFile[2] = "<meta> " + authName + " </meta>";
    htmlFile[3] = "</html>";
    return htmlFile;
  }
}
