package ex42.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordParserTest {

  @Test
  void getTable_small() {
    String[] testStrings = {"Metallica,Ride The Lightning", "Megadeth,Rust In Peace"};
    String[][] expected = {{"Metallica", "Ride The Lightning"}, {"Megadeth", "Rust In Peace"}};
    RecordParser myParser = new RecordParser(testStrings);
    myParser.fillTable();
    assertArrayEquals(expected, myParser.getTable());
  }

  @Test
  void getTable_medium() {
    String[] testStrings = {"Metallica,Ride The Lightning,Creeping Death",
            "Megadeth,Rust In Peace,Take No Prisoners", "Pantera,Cowboys From Hell,Cemetery Gates"};
    String[][] expected = {{"Metallica", "Ride The Lightning", "Creeping Death"},
            {"Megadeth", "Rust In Peace", "Take No Prisoners"},
            {"Pantera", "Cowboys From Hell", "Cemetery Gates"}};
    RecordParser myParser = new RecordParser(testStrings);
    myParser.fillTable();
    assertArrayEquals(expected, myParser.getTable());
  }

  @Test
  void getTable_large() {
    String[] testStrings = {"Thrash Metal,Metallica,Ride The Lightning,Creeping Death",
            "Progressive Thrash Metal,Megadeth,Rust In Peace,Take No Prisoners",
            "Groove Metal,Pantera,Cowboys From Hell,Cemetery Gates",
            "Melodic Death Metal,In Flames,Clayman,Only For The Weak"};
    String[][] expected = {{"Thrash Metal", "Metallica", "Ride The Lightning", "Creeping Death"},
            {"Progressive Thrash Metal", "Megadeth", "Rust In Peace", "Take No Prisoners"},
            {"Groove Metal", "Pantera", "Cowboys From Hell", "Cemetery Gates"},
            {"Melodic Death Metal", "In Flames", "Clayman", "Only For The Weak"}};
    RecordParser myParser = new RecordParser(testStrings);
    myParser.fillTable();
    assertArrayEquals(expected, myParser.getTable());
  }
}