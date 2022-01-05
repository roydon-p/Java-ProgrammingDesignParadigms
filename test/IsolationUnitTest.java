import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import primatesanctuary.FoodType;
import primatesanctuary.IsolationUnit;
import primatesanctuary.Housing;
import primatesanctuary.Monkey;
import primatesanctuary.MonkeyGender;
import primatesanctuary.MonkeySize;
import primatesanctuary.MonkeySpecies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing the Isolation Unit class.
 */
public class IsolationUnitTest {
  private Housing housingUnit;

  /**
   * Creates instance of a new Isolation Unit object.
   *
   * <p>return a new instance of a IsolationUnit object
   */
  protected Housing housingUnit() {
    return new IsolationUnit();
  }

  @Before
  public void setUp() {
    housingUnit = housingUnit();
  }

  @Test
  public void isEnclosure() {
    assertFalse(housingUnit.isEnclosure());
  }

  @Test
  public void addMonkeyValidCase() {
    Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE, MonkeySpecies.HOWLER,
            FoodType.SEEDS, 12, 2, new Date());
    assertTrue(housingUnit.addMonkey(m));
  }

  @Test
  public void addMonkeyInvalidCase() {
    Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE, MonkeySpecies.HOWLER,
            FoodType.SEEDS, 12, 2, new Date());
    assertTrue(housingUnit.addMonkey(m));
    assertFalse(housingUnit.addMonkey(m));
  }

  @Test
  public void addNullMonkey() {
    assertFalse(housingUnit.addMonkey(null));
  }

  @Test
  public void removeValidMonkey() {
    Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE, MonkeySpecies.HOWLER,
            FoodType.SEEDS, 12, 2, new Date());
    assertTrue(housingUnit.addMonkey(m));
    assertTrue(housingUnit.removeMonkey(m));
  }

  @Test
  public void removeInvalidMonkey() {
    Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE, MonkeySpecies.HOWLER,
            FoodType.SEEDS, 12, 2, new Date());
    assertFalse(housingUnit.removeMonkey(m));
  }

  @Test
  public void removeNullMonkey() {
    assertFalse(housingUnit.removeMonkey(null));
  }

  @Test
  public void getValidMonkeyList() {
    Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE, MonkeySpecies.HOWLER,
            FoodType.SEEDS, 12, 2, new Date());
    housingUnit.addMonkey(m);
    List<Monkey> monkeyList = new ArrayList<>();
    monkeyList.add(m);
    assertEquals(monkeyList, housingUnit.getMonkeyList());
  }


  @Test
  public void getInvalidMonkeyList() {
    Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE, MonkeySpecies.HOWLER,
            FoodType.SEEDS, 12, 2, new Date());
    housingUnit.addMonkey(m);
    List<Monkey> monkeyList = new ArrayList<>();
    monkeyList.add(null);
    assertNotEquals(monkeyList, housingUnit.getMonkeyList());
  }

  @Test
  public void getValidSize() {
    int expected = 10;
    assertEquals(expected, housingUnit.getSize());
  }

  @Test
  public void getInvalidSize() {
    int expected = 50;
    assertNotEquals(expected, housingUnit.getSize());
  }

  @Test
  public void getValidLocation() {
    //String expected = "Isolation Unit: I1"; //for individual test case use this(static counter)
    String expected = "Isolation Unit: I8";
    assertEquals(expected, housingUnit.getLocation());
  }

  @Test
  public void getInvalidLocation() {
    String expected = "";
    assertNotEquals(expected, housingUnit.getLocation());
  }

  @Test
  public void getValidSpecies() {
    Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE, MonkeySpecies.HOWLER,
            FoodType.SEEDS, 12, 2, new Date());
    housingUnit.addMonkey(m);
    assertEquals(MonkeySpecies.HOWLER, housingUnit.getSpecies());
  }

  @Test
  public void getValidStringSpecies() {
    Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE, MonkeySpecies.HOWLER,
            FoodType.SEEDS, 12, 2, new Date());
    housingUnit.addMonkey(m);
    MonkeySpecies expected = MonkeySpecies.valueOf("HOWLER");
    assertEquals(expected, housingUnit.getSpecies());
  }

  @Test
  public void getInvalidSpecies() {
    Monkey m = new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE, MonkeySpecies.HOWLER,
            FoodType.SEEDS, 12, 2, new Date());
    housingUnit.addMonkey(m);
    MonkeySpecies expected = MonkeySpecies.valueOf("SAKI");
    assertNotEquals(expected, housingUnit.getSpecies());
  }
}