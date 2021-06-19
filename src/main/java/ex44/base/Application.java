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
    Application app = new Application();
    try {
      JsonIO myJson = new JsonIO(new FileReader("./src/main/java/ex44/base/exercise44_input.json"));
      myJson.fillJsonList("products");
      Map<String, Object> myProduct;
      while (true) {
        String name = app.getName();
        myProduct = myJson.findMap("name", name);
        if (myProduct == null) {
          System.out.println("Sorry, that product was not found in our inventory.");
          continue;
        }
        break;
      }
      System.out.println(app.getInfo(myProduct));
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public String getName() {
    System.out.print("What is the product name? ");
    return input.nextLine();
  }

  public String getInfo(Map<String, Object> product) {
    String name = (String) product.get("name");
    double price = (double) product.get("price");
    double quantity = (double) product.get("quantity");
    return String.format("Name: %s%nPrice: %.2f%nQuantity: %.0f%n", name, price, quantity);
  }
}
