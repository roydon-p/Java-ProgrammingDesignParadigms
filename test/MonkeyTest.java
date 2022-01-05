import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import primatesanctuary.FoodType;
import primatesanctuary.Monkey;
import primatesanctuary.MonkeyGender;
import primatesanctuary.MonkeySize;
import primatesanctuary.MonkeySpecies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class for testing the Monkey class.
 */
public class MonkeyTest {
  private Monkey monkey;

  /**
   * Creates instance of a new Monkey object.
   *
   * <p>return a new instance of an Monkey object
   */
  protected Monkey monkey() {
    return new Monkey("abc", MonkeyGender.MALE, MonkeySize.LARGE, MonkeySpecies.HOWLER,
            FoodType.SEEDS, 12, 2, new Date());
  }

  @Before
  public void setUp() {
    monkey = monkey();
  }

  @Test
  public void getMonkeyValidSize() {
    assertEquals(MonkeySize.LARGE,monkey.getMonkeySize());
  }

  @Test
  public void getMonkeyInvalidSize() {
    assertNotEquals(MonkeySize.MEDIUM,monkey.getMonkeySize());
  }

  @Test
  public void getValidMonkeyName() {
    assertEquals("abc",monkey.getMonkeyName());
  }

  @Test
  public void getInvalidMonkeyName() {
    assertNotEquals("abd",monkey.getMonkeyName());
  }

  @Test
  public void getValidMonkeyGender() {
    assertEquals(MonkeyGender.MALE,monkey.getMonkeyGender());
  }

  @Test
  public void getInvalidMonkeyGender() {
    assertNotEquals(MonkeyGender.FEMALE,monkey.getMonkeyGender());
  }

  @Test
  public void getValidFavFood() {
    assertEquals(FoodType.SEEDS,monkey.getFavFood());
  }

  @Test
  public void getInvalidFavFood() {
    assertNotEquals(FoodType.INSECTS,monkey.getFavFood());
  }

  @Test
  public void getValidMonkeySpecies() {
    assertEquals(MonkeySpecies.HOWLER,monkey.getMonkeySpecies());
  }

  @Test
  public void getInvalidMonkeySpecies() {
    assertNotEquals(MonkeySpecies.MANGABEY,monkey.getMonkeySpecies());
  }

  @Test
  public void getValidMonkeyId() {
    assertEquals(15,monkey.getMonkeyId());
  }

  @Test
  public void getInvalidMonkeyId() {
    assertNotEquals(null,monkey.getMonkeyId());
  }

  @Test
  public void getValidWeight() {
    assertEquals(12,monkey.getWeight());
  }

  @Test
  public void getInvalidWeight() {
    assertNotEquals(30,monkey.getWeight());
  }

  @Test
  public void getValidAge() {
    assertEquals(2,monkey.getAge());
  }

  @Test
  public void getInvalidAge() {
    assertNotEquals(3,monkey.getAge());
  }

  @Test
  public void getValidArrivalDate() {
    assertEquals(new Date(),monkey.getArrivalDate());
  }

  @Test
  public void getInvalidArrivalDate() {
    assertNotEquals(null,monkey.getArrivalDate());
  }
}