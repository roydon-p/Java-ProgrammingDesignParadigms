package primatesanctuary;

import java.util.List;

/**
 * Housing represents the operations related to housing the monkeys in a Monkey Sanctuary.
 */
public interface Housing {

  /**
   * Checks if the Housing type is an Enclosure or not.
   *
   * @return true/false based on the implementing class
   */
  public boolean isEnclosure();

  /**
   * Adds the monkey to the Housing Unit.
   *
   * @param m monkey to be moved.
   * @return true/false based on success of the operation.
   */
  public boolean addMonkey(Monkey m);

  /**
   * Removes the monkey from the Housing Unit.
   *
   * @param m monkey to be moved.
   * @return true/false based on success of the operation.
   */
  public boolean removeMonkey(Monkey m);

  /**
   * Gets the list of monkeys that inhabit the housing unit.
   *
   * @return List of monkeys
   */
  public List<Monkey> getMonkeyList();

  /**
   * Gets the Size of the housing unit in sq mt.
   *
   * @return size in sq mt.
   */
  public int getSize();

  /**
   * Gets the location of the housing unit within the sanctuary.
   *
   * @return returns location in form of a string
   */
  public String getLocation();

  /**
   * Gets the Species of the troop of monkey in a particular housing unit.
   *
   * @return species of the Monkey
   */
  public MonkeySpecies getSpecies();
}
