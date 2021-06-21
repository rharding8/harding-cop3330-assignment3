/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Harding
 */

package ex41.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameManagerTest {

  @Test
  void set_and_getNames() {
    String[] expected = {"James Hetfield", "Kirk Hammett", "Lars Ulrich", "Cliff Burton"};
    NameManager names = new NameManager();
    names.setNames(expected);
    String[] actual = names.getNames();
    assertArrayEquals(expected, actual);
  }

  @Test
  void sort_and_get_namesAlpha() {
    String[] original = {"Rorschach", "Doctor Manhattan", "Silk Spectre", "Nite Owl", "Ozymandias"};
    String[] expected = {"Doctor Manhattan", "Nite Owl", "Ozymandias", "Rorschach", "Silk Spectre"};
    NameManager names = new NameManager();
    names.setNames(original);
    names.sortAlpha();
    String[] actual = names.getNames();
    assertArrayEquals(expected, actual);
  }
}