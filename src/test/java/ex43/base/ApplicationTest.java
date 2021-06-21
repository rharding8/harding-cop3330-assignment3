/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Harding
 */

package ex43.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

  @Test
  void craftHTML() {
    String web = "Testing Site";
    String author = "Tester";
    String[] expected = {"<html>", "<title> Testing Site </title>", "<meta> Tester </meta>", "</html>"};
    Application app = new Application();
    String[] actual = app.craftHTML(web, author);
    assertArrayEquals(expected, actual);
  }
}