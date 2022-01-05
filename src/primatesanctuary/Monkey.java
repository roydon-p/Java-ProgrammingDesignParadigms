package primatesanctuary;

import java.util.Date;

/**
 * Represents a single monkey and its attributes that exists in a Sanctuary.
 * The data for monkey comes into existence only when it enters the sanctuary.
 */
public class Monkey {
  private final int monkey_id;
  private final String name;
  private final MonkeyGender gender;
  private final MonkeySize size;
  private final MonkeySpecies species;
  private final FoodType favFood;
  private final int weight;
  private final int age;
  private final Date arrivalDate;
  private static int counter = 0;

  /**
   * Creates a monkey with the attributes passed by the calling function.
   *
   * @param name        name of the monkey
   * @param gender      gender of the monkey
   * @param size        size of the monkey
   * @param species     species the monkey belongs to
   * @param favFood     favorite food item of the monkey
   * @param weight      weight of the monkey
   * @param age         age of the monkey
   * @param arrivalDate the date that the monkey arrived in the sanctuary
   */
  public Monkey(String name, MonkeyGender gender, MonkeySize size,
                MonkeySpecies species, FoodType favFood, int weight, int age, Date arrivalDate) {
    counter++;
    this.monkey_id = counter;
    this.name = name;
    this.gender = gender;
    this.size = size;
    this.species = species;
    this.favFood = favFood;
    this.weight = weight;
    this.age = age;
    this.arrivalDate = arrivalDate;
  }

  public MonkeySize getMonkeySize() {
    return this.size;
  }

  public String getMonkeyName() {
    return this.name;
  }

  public MonkeyGender getMonkeyGender() {
    return this.gender;
  }

  public FoodType getFavFood() {
    return this.favFood;
  }

  public MonkeySpecies getMonkeySpecies() {
    return this.species;
  }

  public int getMonkeyId() {
    return this.monkey_id;
  }

  public int getWeight() {
    return this.weight;
  }

  public int getAge() {
    return this.age;
  }

  public Date getArrivalDate() {
    return this.arrivalDate;
  }

  @Override
  public String toString() {
    return name;
  }
}
