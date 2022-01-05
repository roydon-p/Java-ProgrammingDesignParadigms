import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import primatesanctuary.Enclosure;
import primatesanctuary.FoodType;
import primatesanctuary.Housing;
import primatesanctuary.Monkey;
import primatesanctuary.MonkeyGender;
import primatesanctuary.MonkeySize;
import primatesanctuary.MonkeySpecies;
import primatesanctuary.Sanctuary;
import primatesanctuary.SanctuaryM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing the SanctuaryM class.
 */
public class SanctuaryMTest {
  private Sanctuary sanctuary;

  /**
   * Creates instance of a new Sanctuary object.
   *
   * <p>return a new instance of a Sanctuary object
   */
  protected Sanctuary sanctuary() {
    return new SanctuaryM(2, 3);
  }

  @Before
  public void setUp() {
    sanctuary = sanctuary();
  }

  @Test
  public void testSanctuaryInitialized() {
    assertEquals(5, sanctuary.getHousingList().size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSanctuary() {
    Sanctuary s = new SanctuaryM(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIncreaseSanctuaryCapacity() {
    sanctuary.increaseSanctuaryCapacity(0);
  }

  @Test
  public void testIncreaseSanctuaryCapacity() {
    sanctuary.increaseSanctuaryCapacity(10);
    sanctuary.createIsolationUnits();
    assertEquals(6, sanctuary.getHousingList().size());
  }

  @Test(expected = IllegalStateException.class)
  public void createIsolationUnitsFullSanctuary() {
    sanctuary.createIsolationUnits();
  }

  @Test(expected = IllegalStateException.class)
  public void createEnclosureFullSanctuary() {
    sanctuary.createEnclosure(10);
  }

  @Test
  public void createExtraEnclosureForExtraAreaSanctuary() {
    sanctuary.increaseSanctuaryCapacity(50);
    sanctuary.createEnclosure(50);
    assertEquals(6, sanctuary.getHousingList().size());
  }

  @Test(expected = IllegalStateException.class)
  public void createExtraEnclosureOverExtraAreaSanctuary() {
    sanctuary.increaseSanctuaryCapacity(50);
    sanctuary.createEnclosure(60);
  }

  @Test
  public void checkNoSpaceAvailability() {
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
                MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
        h.addMonkey(m);
      }
    }
    assertFalse(sanctuary.checkSpaceAvailability());
  }

  @Test
  public void checkYesSpaceAvailability() {
    for (Housing h : sanctuary.getHousingList()) {
      if (h.isEnclosure()) {
        Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
                MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
        h.addMonkey(m);
      }
    }
    assertTrue(sanctuary.checkSpaceAvailability());
  }

  @Test
  public void addValidNewMonkey() {
    assertEquals(0, sanctuary.getMonkeyList().size());
    sanctuary.addNewMonkey("abc", "MALE", "LARGE", "HOWLER",
            "SEEDS", 12, 2);
    assertEquals(1, sanctuary.getMonkeyList().size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addIncorrectStringInputNewMonkey() {
    assertEquals(0, sanctuary.getMonkeyList().size());
    sanctuary.addNewMonkey("abc", "Male", "LARGE", "HOWLER",
            "SEEDS", 12, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void addIncorrectIntInputNewMonkey() {
    assertEquals(0, sanctuary.getMonkeyList().size());
    sanctuary.addNewMonkey("abc", "MALE", "LARGE", "HOWLER",
            "SEEDS", 0, 0);
  }

  @Test(expected = IllegalStateException.class)
  public void addNewMonkeyFullCapacity() {
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
                MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
        h.addMonkey(m);
      }
    }
    assertEquals(3, sanctuary.getMonkeyList().size());
    sanctuary.addNewMonkey("abc", "MALE", "LARGE", "HOWLER",
            "SEEDS", 10, 2);
  }

  @Test
  public void moveMonkeyValid() {
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
                MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
        h.addMonkey(m);
      }
    }
    for (Housing h : sanctuary.getHousingList()) {
      if (h.isEnclosure()) {
        for (Monkey m : h.getMonkeyList()) {
          sanctuary.moveMonkey(m, sanctuary.getHousingList().get(4));
        }
      }
    }
    assertEquals(3, sanctuary.getMonkeyList().size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveMonkeyInvalidDestination() {
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
                MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
        h.addMonkey(m);
      }
    }
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        for (Monkey m : h.getMonkeyList()) {
          sanctuary.moveMonkey(m, new Enclosure(10));
        }
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveMonkeyInvalidMonkey() {
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
                MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
        h.addMonkey(m);
      }
    }
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        sanctuary.moveMonkey(new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
                MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date()), h);
      }
    }
  }

  @Test
  public void autoMoveMonkeyToEnclosure() {
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.SMALL,
                MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
        h.addMonkey(m);
      }
    }
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        for (Monkey m : h.getMonkeyList()) {
          sanctuary.autoMoveMonkeyToEnclosure(m);
          break;
        }
      }
    }
    assertEquals(3, sanctuary.getMonkeyList().size());
  }

  @Test
  public void autoMoveMonkeyToIsolationUnit() {
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.SMALL,
                MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
        h.addMonkey(m);
      }
    }
    for (Housing h : sanctuary.getHousingList()) {
      if (!h.isEnclosure()) {
        for (Monkey m : h.getMonkeyList()) {
          sanctuary.autoMoveMonkeyToEnclosure(m);
          break;
        }
      }
    }
    for (Housing h : sanctuary.getHousingList()) {
      if (h.isEnclosure()) {
        for (Monkey m : h.getMonkeyList()) {
          sanctuary.autoMoveMonkeyToIsolationUnit(m);
          break;
        }
      }
    }
    assertEquals(3, sanctuary.getMonkeyList().size());
  }

  @Test
  public void getSpeciesList() {
    for (Housing h : sanctuary.getHousingList()) {
      Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
              MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
      h.addMonkey(m);
    }
    List<String> m = new ArrayList<>();
    m.add("DRILL - This species is currently not housed in the Sanctuary.");
    m.add("GUEREZA - This species is currently not housed in the Sanctuary.");
    m.add("HOWLER - Enclosure: E5, Enclosure: E6, Isolation Unit: I7, Isolation Unit: I8, "
            + "Isolation Unit: I9, ");
    m.add("MANGABEY - This species is currently not housed in the Sanctuary.");
    m.add("OTHER - This species is currently not housed in the Sanctuary.");
    m.add("SAKI - This species is currently not housed in the Sanctuary.");
    m.add("SPIDER - This species is currently not housed in the Sanctuary.");
    m.add("SQUIRREL - This species is currently not housed in the Sanctuary.");
    m.add("TAMARIN - This species is currently not housed in the Sanctuary.");
    assertEquals(m, sanctuary.getSpeciesList());
  }

  @Test
  public void lookUpSpeciesLocation() {
    for (Housing h : sanctuary.getHousingList()) {
      Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
              MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
      h.addMonkey(m);
    }
    String expected = "Enclosure: E37, Enclosure: E38, Isolation Unit: I53, Isolation Unit: I54, "
            + "Isolation Unit: I55, ";
    assertEquals(expected, sanctuary.lookUpSpeciesLocation(MonkeySpecies.HOWLER));
  }

  @Test
  public void lookUpNonPresentSpeciesLocation() {
    for (Housing h : sanctuary.getHousingList()) {
      Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
              MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
      h.addMonkey(m);
    }
    String expected = "This species is currently not housed in the Sanctuary.";
    assertEquals(expected, sanctuary.lookUpSpeciesLocation(MonkeySpecies.TAMARIN));
  }

  @Test
  public void getMonkeyList() {
    for (Housing h : sanctuary.getHousingList()) {
      Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
              MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
      h.addMonkey(m);
    }
    List<String> m = new ArrayList<>();
    m.add("abc - Enclosure: E7");
    m.add("abc - Enclosure: E8");
    m.add("abc - Isolation Unit: I10");
    m.add("abc - Isolation Unit: I11");
    m.add("abc - Isolation Unit: I12");
    assertEquals(m, sanctuary.getMonkeyList());
  }

  @Test
  public void createShoppingList() {
    for (Housing h : sanctuary.getHousingList()) {
      Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
              MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
      h.addMonkey(m);
    }
    List<String> m = new ArrayList<>();
    m.add("EGGS - 0 gr");
    m.add("FRUITS - 0 gr");
    m.add("INSECTS - 0 gr");
    m.add("LEAVES - 0 gr");
    m.add("NUTS - 0 gr");
    m.add("SEEDS - 2500 gr");
    m.add("TREESAP - 0 gr");
    m.add("OTHER - 0 gr");
    assertEquals(m, sanctuary.createShoppingList());
  }

  @Test
  public void getEnclosureSign() {
    for (Housing h : sanctuary.getHousingList()) {
      Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
              MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
      h.addMonkey(m);
    }
    for (Housing h : sanctuary.getHousingList()) {
      assertEquals("Enclosure: E9\n" +
              "-----------------------------------------\n" +
              "Name: abc\n" +
              "Sex: MALE\n" +
              "Favorite Food: SEEDS\n" +
              "-----------------------------------------", sanctuary.getEnclosureSign(h));
      break;
    }
  }

  @Test
  public void getHousingList() {
    for (Housing h : sanctuary.getHousingList()) {
      Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE,
              MonkeySpecies.HOWLER, FoodType.SEEDS, 12, 2, new Date());
      h.addMonkey(m);
    }
    assertEquals(5, sanctuary.getHousingList().size());
  }
}