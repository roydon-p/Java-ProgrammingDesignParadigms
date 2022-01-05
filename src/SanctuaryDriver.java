import primatesanctuary.Housing;
import primatesanctuary.Monkey;
import primatesanctuary.MonkeySpecies;
import primatesanctuary.Sanctuary;
import primatesanctuary.SanctuaryM;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class created to demonstrate the Run of Sanctuary interface implementation.
 */
public class SanctuaryDriver {
  /**
   * Main method contains all the calls to the public operations of Sanctuary interface
   * that has been implemented for the Monkey Sanctuary.
   *
   * @param args passes parameters to a string array through the console window.
   */
  public static void main(String []args) {
    //initialize a sanctuary with 2 enclosures and 3 isolation units
    Sanctuary s = new SanctuaryM(2, 3);

    //get list of monkeys in the sanctuary
    List<Housing> housings = s.getHousingList();
    List<Monkey> monkeys = new ArrayList<>();
    for (Housing h : housings) {
      for (Monkey m : h.getMonkeyList()) {
        monkeys.add(m);
      }
    }
    System.out.println("List of Monkeys in Sanctuary:" + monkeys);
    System.out.println("\n---------------------------------------------");

    //get list of inhabitants and their housing units
    System.out.println("List of Monkeys(with Location):");
    for (String item : s.getMonkeyList()) {
      System.out.println(item);
    }
    System.out.println("\n---------------------------------------------");

    //add monkeys to the sanctuary
    s.addNewMonkey("Chewy", "MALE", "MEDIUM", "HOWLER",
            "LEAVES", 20, 2);
    s.addNewMonkey("Momo", "MALE", "LARGE", "DRILL",
            "EGGS", 35, 3);
    s.addNewMonkey("Alex", "FEMALE", "SMALL", "DRILL",
            "FRUITS", 15, 1);
    System.out.println("3 monkeys added.");
    System.out.println("\n---------------------------------------------");

    //get list of inhabitants and their housing units(alphabetical order)
    System.out.println("List of Monkeys(with Location):");
    for (String item : s.getMonkeyList()) {
      System.out.println(item);
    }
    System.out.println("\n---------------------------------------------");

    //move all monkeys to enclosures automatically
    housings = s.getHousingList();
    monkeys = new ArrayList<>();
    for (Housing h : housings) {
      for (Monkey m : h.getMonkeyList()) {
        monkeys.add(m);
      }
    }
    for (Monkey m : monkeys) {
      s.autoMoveMonkeyToEnclosure(m);
    }
    System.out.println("monkeys moved to enclosures automatically.");
    System.out.println("\n---------------------------------------------");

    //get list of inhabitants and their housing units(alphabetical order)
    System.out.println("List of Monkeys(with Location):");
    for (String item : s.getMonkeyList()) {
      System.out.println(item);
    }
    System.out.println("\n---------------------------------------------");

    //check if space is available to add new monkeys
    if (s.checkSpaceAvailability()) {
      System.out.println("Space is available for new monkeys.");
    } else {
      System.out.println("Space is not available for new monkeys.");
    }
    System.out.println("\n---------------------------------------------");

    //add new monkeys to the sanctuary(to full capacity)
    //add 3 monkeys
    s.addNewMonkey("Hat", "MALE", "LARGE", "DRILL",
            "LEAVES", 30, 2);
    s.addNewMonkey("Tully", "MALE", "LARGE", "DRILL",
            "TREESAP", 35, 3);
    s.addNewMonkey("Penny", "FEMALE", "LARGE", "DRILL",
            "FRUITS", 34, 1);
    //move the 3 monkeys to enclosures automatically
    housings = s.getHousingList();
    monkeys = new ArrayList<>();
    for (Housing h : housings) {
      for (Monkey m : h.getMonkeyList()) {
        monkeys.add(m);
      }
    }
    for (Monkey m : monkeys) {
      s.autoMoveMonkeyToEnclosure(m);
    }
    //add 3 monkeys
    s.addNewMonkey("Raja", "MALE", "MEDIUM", "DRILL",
            "LEAVES", 20, 2);
    s.addNewMonkey("Chachi", "FEMALE", "SMALL", "DRILL",
            "EGGS", 35, 3);
    s.addNewMonkey("Zoey", "FEMALE", "SMALL", "DRILL",
            "NUTS", 15, 1);
    //move the 3 monkeys to enclosures automatically
    housings = s.getHousingList();
    monkeys = new ArrayList<>();
    for (Housing h : housings) {
      for (Monkey m : h.getMonkeyList()) {
        monkeys.add(m);
      }
    }
    for (Monkey m : monkeys) {
      s.autoMoveMonkeyToEnclosure(m);
    }
    //add 3 monkeys
    s.addNewMonkey("Piper", "MALE", "SMALL", "DRILL",
            "INSECTS", 20, 2);
    s.addNewMonkey("Milo", "MALE", "SMALL", "DRILL",
            "EGGS", 35, 3);
    s.addNewMonkey("Mela", "FEMALE", "LARGE", "HOWLER",
            "SEEDS", 15, 1);
    //move the 3 monkeys to enclosures automatically
    housings = s.getHousingList();
    monkeys = new ArrayList<>();
    for (Housing h : housings) {
      for (Monkey m : h.getMonkeyList()) {
        monkeys.add(m);
      }
    }
    for (Monkey m : monkeys) {
      s.autoMoveMonkeyToEnclosure(m);
    }
    //add 3 monkeys
    s.addNewMonkey("Tupac", "MALE", "LARGE", "HOWLER",
            "LEAVES", 20, 2);
    s.addNewMonkey("Noah", "MALE", "LARGE", "HOWLER",
            "EGGS", 35, 3);
    s.addNewMonkey("Peanut", "FEMALE", "MEDIUM", "HOWLER",
            "FRUITS", 15, 1);
    //move the 3 monkeys to enclosures automatically
    housings = s.getHousingList();
    monkeys = new ArrayList<>();
    for (Housing h : housings) {
      for (Monkey m : h.getMonkeyList()) {
        monkeys.add(m);
      }
    }
    for (Monkey m : monkeys) {
      s.autoMoveMonkeyToEnclosure(m);
    }
    //add 2 monkeys
    s.addNewMonkey("Rick", "MALE", "MEDIUM", "HOWLER",
            "LEAVES", 20, 2);
    s.addNewMonkey("Rikki", "MALE", "MEDIUM", "HOWLER",
            "EGGS", 35, 3);
    //move the 2 monkeys to enclosures automatically
    housings = s.getHousingList();
    monkeys = new ArrayList<>();
    for (Housing h : housings) {
      for (Monkey m : h.getMonkeyList()) {
        monkeys.add(m);
      }
    }
    for (Monkey m : monkeys) {
      s.autoMoveMonkeyToEnclosure(m);
    }
    //add 3 monkeys
    s.addNewMonkey("Molly", "FEMALE", "MEDIUM", "HOWLER",
            "FRUITS", 15, 1);
    s.addNewMonkey("Morty", "MALE", "LARGE", "HOWLER",
            "LEAVES", 20, 2);
    s.addNewMonkey("Tom", "MALE", "LARGE", "SPIDER",
            "EGGS", 35, 3);
    System.out.println("17 new monkeys added.");
    System.out.println("\n---------------------------------------------");

    //get list of inhabitants and their housing units(alphabetical order)
    System.out.println("List of Monkeys(with Location):");
    for (String item : s.getMonkeyList()) {
      System.out.println(item);
    }
    System.out.println("\n---------------------------------------------");

    //move a monkey from enclosure to a specific isolation unit(check capacity full condition)
    System.out.println("Move from Enclosure to an Isolation Unit");
    try {
      housings = s.getHousingList();
      for (Housing e : housings) {
        //get a monkey from housing list(enclosure)
        for (Monkey m : e.getMonkeyList()) {
          if (e.isEnclosure()) {
            //get a destination from housing list(isolation unit)
            for (Housing i : housings) {
              if (!i.isEnclosure()) {
                s.moveMonkey(m, i);
              }
            }
          }
        }
      }
    } catch (Exception e) {
      System.out.println("Exception Caught: " + e.getMessage());
    }
    System.out.println("\n---------------------------------------------");

    //move a monkey from isolation unit to a specific enclosure(check capacity full condition)
    System.out.println("Move from Isolation Unit to an Enclosure");
    try {
      housings = s.getHousingList();
      for (Housing i : housings) {
        //get a monkey from housing list(isolation unit)
        for (Monkey m : i.getMonkeyList()) {
          if (!i.isEnclosure()) {
            //get a destination from housing list(enclosure)
            for (Housing e : housings) {
              if (e.isEnclosure()) {
                s.moveMonkey(m, e);
              }
            }
          }
        }
      }
    } catch (Exception e) {
      System.out.println("Exception Caught: " + e.getMessage());
    }
    System.out.println("\n---------------------------------------------");

    //check if space is available to add new monkeys
    if (s.checkSpaceAvailability()) {
      System.out.println("Space is available for new monkeys.");
    } else {
      System.out.println("Space is not available for new monkeys.");
    }
    System.out.println("\n---------------------------------------------");

    //add new enclosures and isolation units(no space available)
    System.out.println("Adding a new Enclosure and Isolation Unit");
    try {
      s.createEnclosure(15);
    } catch (Exception e) {
      System.out.println("Exception Caught: " + e.getMessage());
    }

    try {
      s.createIsolationUnits();
    } catch (Exception e) {
      System.out.println("Exception Caught: " + e.getMessage());
    }
    System.out.println("\n---------------------------------------------");

    //increase the sanctuary capacity
    s.increaseSanctuaryCapacity(165);
    System.out.println("Sanctuary area expanded by 165 sq mt.");
    System.out.println("\n---------------------------------------------");

    //add new enclosures and isolation units
    System.out.println("Adding 3 new Enclosures(size:25,20,40 sqmt) and 8 new Isolation Units.");
    s.createEnclosure(25);
    s.createEnclosure(20);
    s.createEnclosure(40);
    for (int i = 0; i < 8; i++) {
      s.createIsolationUnits();
    }
    System.out.println("Added 3 new Enclosures(size:25,20,40 sqmt) and 8 new Isolation Units.");

    //check if space is available to add new monkeys
    if (s.checkSpaceAvailability()) {
      System.out.println("Space is available for new monkeys.");
    } else {
      System.out.println("Space is not available for new monkeys.");
    }
    System.out.println("\n---------------------------------------------");

    //add new monkeys to the sanctuary
    //add 8 monkeys
    s.addNewMonkey("Gizmo", "MALE", "SMALL", "SPIDER",
            "LEAVES", 20, 2);
    s.addNewMonkey("Goldie", "MALE", "SMALL", "SPIDER",
            "EGGS", 35, 3);
    s.addNewMonkey("Pat", "FEMALE", "MEDIUM", "SPIDER",
            "FRUITS", 15, 1);
    s.addNewMonkey("Travis", "MALE", "LARGE", "SAKI",
            "LEAVES", 20, 2);
    s.addNewMonkey("Jerry", "MALE", "LARGE", "SAKI",
            "EGGS", 35, 3);
    s.addNewMonkey("Lizzy", "FEMALE", "MEDIUM", "SAKI",
            "FRUITS", 15, 1);
    s.addNewMonkey("Mike", "MALE", "LARGE", "MANGABEY",
            "LEAVES", 20, 2);
    s.addNewMonkey("Jose", "MALE", "LARGE", "MANGABEY",
            "EGGS", 35, 3);
    System.out.println("8 new monkeys added.");
    //move all the monkeys from isolation units to enclosures automatically
    housings = s.getHousingList();
    monkeys = new ArrayList<>();
    for (Housing h : housings) {
      for (Monkey m : h.getMonkeyList()) {
        monkeys.add(m);
      }
    }
    for (Monkey m : monkeys) {
      try {
        s.autoMoveMonkeyToEnclosure(m);
      } catch (Exception e) {
        System.out.println("Exception Caught: " + e.getMessage());
      }
    }
    System.out.println("\n---------------------------------------------");

    //get list of inhabitants and their housing units(alphabetical order)
    System.out.println("List of Monkeys(with Location):");
    for (String item : s.getMonkeyList()) {
      System.out.println(item);
    }
    System.out.println("\n---------------------------------------------");

    //check if space is available to add new monkeys
    if (s.checkSpaceAvailability()) {
      System.out.println("Space is available for new monkeys.");
    } else {
      System.out.println("Space is not available for new monkeys.");
    }
    System.out.println("\n---------------------------------------------");

    //get list of species and their locations(alphabetical order)
    System.out.println("Species List(with Location):");
    for (String species : s.getSpeciesList()) {
      System.out.println(species);
    }
    System.out.println("\n---------------------------------------------");

    //look up the location of a specific species in the sanctuary
    System.out.println("Locations of Howler species: "
            + s.lookUpSpeciesLocation(MonkeySpecies.HOWLER));
    System.out.println("Locations of Tamarin species: "
            + s.lookUpSpeciesLocation(MonkeySpecies.TAMARIN));
    System.out.println("Locations of Mangabey species: "
            + s.lookUpSpeciesLocation(MonkeySpecies.MANGABEY));

    System.out.println("\n---------------------------------------------");

    //generate a shopping list for all inhabitants of the sanctuary
    System.out.println("Shopping List:");
    for (String slist : s.createShoppingList()) {
      System.out.println(slist);
    }
    System.out.println("\n---------------------------------------------");

    //generate a sign for a specific enclosure in the sanctuary
    for (Housing h : housings) {
      System.out.println("Enclosure Sign for " + s.getEnclosureSign(h));
      break;
    }
    System.out.println("\n---------------------------------------------");
  }
}
