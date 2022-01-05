package primatesanctuary;


import java.util.List;

/**
 * A Sanctuary represents the data and operations that happen in a Monkey Sanctuary.
 * Classes that implement this interface will vary depending
 * upon the type of operations done in that sanctuary.
 */
public interface Sanctuary {

  /**
   * Creates an enclosure in the Sanctuary.
   *
   * @param size size of enclosure in sq mt.
   * @throws IllegalStateException if Sanctuary does not have space to add more enclosures
   *                               of given size.
   */
  public void createEnclosure(int size) throws IllegalStateException;

  /**
   * Creates an isolation unit in the Sanctuary.
   *
   * @throws IllegalStateException if Sanctuary does not have space to add more isolation units.
   */
  public void createIsolationUnits() throws IllegalStateException;

  /**
   * Increases the area of Sanctuary by value passed in parameter(in sq mt).
   *
   * @param additionalSanctuaryArea additional area for sanctuary expansion in sq mt.
   * @throws IllegalStateException if Sanctuary does not have space to add more enclosures
   *                               of given size.
   */
  public void increaseSanctuaryCapacity(int additionalSanctuaryArea);

  /**
   * Checks all the available Isolation Units to see if any new monkey can be brought to the
   * Sanctuary.
   *
   * @return true/false value
   */
  public boolean checkSpaceAvailability();

  /**
   * Adds a new monkey to the Sanctuary.
   *
   * @param name    name of the monkey
   * @param gender  gender of the monkey
   * @param size    size of the monkey (Large, medium, small)
   * @param species species the monkey belongs to. (drill, guereza, howler, mangabey, saki, spider,
   *                squirrel, and tamarin)
   * @param favFood favorite food of the monkey (eggs, fruits, insects, leaves, nuts, seeds,
   *                and tree sap)
   * @param weight  weight of the monkey
   * @param age     age of the monkey
   * @throws IllegalStateException    if no isolation unit is available to house the monkey.
   * @throws IllegalArgumentException if the input values are not in proper format.
   */
  public void addNewMonkey(String name, String gender, String size, String species,
                           String favFood, int weight, int age)
          throws IllegalStateException, IllegalArgumentException;

  /**
   * Moves a monkey to the given destination.
   *
   * @param m    the monkey to be moved
   * @param dest object of the destination location
   * @throws IllegalStateException    if no suitable destination is found for the monkey.
   * @throws IllegalArgumentException if the monkey does not exist in the sanctuary.
   */
  public void moveMonkey(Monkey m, Housing dest)
          throws IllegalStateException, IllegalArgumentException;

  /**
   * moves the monkey to an Enclosure automatically.
   *
   * @param m the monkey to be moved
   * @throws IllegalStateException    if no suitable Enclosure is found for the monkey.
   * @throws IllegalArgumentException if the monkey does not exist in the sanctuary.
   */
  public void autoMoveMonkeyToEnclosure(Monkey m)
          throws IllegalStateException, IllegalArgumentException;

  /**
   * moves the monkey to an Isolation Unit automatically.
   *
   * @param m the monkey to be moved
   * @throws IllegalStateException    if no suitable Isolation Unit is found for the monkey.
   * @throws IllegalArgumentException if the monkey does not exist in the sanctuary.
   */
  public void autoMoveMonkeyToIsolationUnit(Monkey m)
          throws IllegalStateException, IllegalArgumentException;

  /**
   * List of species that are currently being housed in the Sanctuary and their locations
   * in alphabetical order.
   *
   * @return List of Strings containing the species and its locations.
   */
  public List<String> getSpeciesList();

  /**
   * String of locations for a species and reports if a species does not exist in the
   * Sanctuary.
   *
   * @param s species of the monkey
   * @return String of locations for a species
   */
  public String lookUpSpeciesLocation(MonkeySpecies s);

  /**
   * List of all the monkeys in the Sanctuary in alphabetical order along with its location.
   *
   * @return List of monkeys
   */
  public List<String> getMonkeyList();

  /**
   * Shopping list of favorite foods of the inhabitants of the Sanctuary.
   * Large monkeys receive 500 gr of their favorite food while medium and small monkeys
   * require 250 gr and 100 gr respectively.
   *
   * @return List of food and required quantity
   */
  public List<String> createShoppingList();

  /**
   * Produces a sign for a given enclosure.
   *
   * @return String that lists each individual monkey in the enclosure with its details
   *         (name, sex, and favorite food)
   */
  public String getEnclosureSign(Housing h);


  /**
   * gets the list of all housing units in the Sanctuary.
   *
   * @return List of housing units
   */
  public List<Housing> getHousingList();

}
