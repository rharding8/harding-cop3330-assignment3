/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Ryan Harding
 */

package ex44.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

public class Application {
  Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    // Instantiate Application as app
    Application app = new Application();
    try {
      // Instantiate JsonIO as myJson with the given input file
      // fill the jsonList arraylist in myJson
      // Declare product myProduct
      JsonIO myJson = new JsonIO(new FileReader("./src/main/java/ex44/base/exercise44_input.json"));
      myJson.fillJsonList("products");
      Map<String, Object> myProduct;
      // while true loop
      //  store name from getName() input in app
      //  set myProduct to product matching that name
      //  if no product exists
      //    print a fail message and continue loop
      //  otherwise break
      while (true) {
        String name = app.getName();
        myProduct = myJson.findMap("name", name);
        if (myProduct == null) {
          System.out.println("Sorry, that product was not found in our inventory.");
          continue;
        }
        break;
      }
      // print call to getInfo in app using myProduct
      System.out.println(app.getInfo(myProduct));
    }
    catch (FileNotFoundException e) {
      // If FileReader throws exception, catch and print stack trace
      e.printStackTrace();
    }
  }

  public String getName() {
    // Read product name from input
    System.out.print("What is the product name? ");
    return input.nextLine();
  }

  public String getInfo(Map<String, Object> product) {
    // Print out name, price, and quantity of given product
    String name = (String) product.get("name");
    double price = (double) product.get("price");
    double quantity = (double) product.get("quantity");
    return String.format("Name: %s%nPrice: %.2f%nQuantity: %.0f", name, price, quantity);
  }
}
