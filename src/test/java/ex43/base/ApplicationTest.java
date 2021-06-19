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