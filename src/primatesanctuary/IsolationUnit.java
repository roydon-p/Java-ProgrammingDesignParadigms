package primatesanctuary;

import java.util.ArrayList;
import java.util.List;

/**
 * Isolation Unit is a type of Housing which is available for the individual monkeys
 * in the Sanctuary.
 */
public class IsolationUnit implements Housing {

  private final String isolationUnit_id;
  private static int counter;
  private final List<Monkey> monkeys = new ArrayList<Monkey>();

  /**
   * Constructs an Isolation Unit and sets the Id for it.
   */
  public IsolationUnit() {
    counter++;
    this.isolationUnit_id = "I" + counter;
  }

  @Override
  public boolean isEnclosure() {
    return false;
  }

  @Override
  public boolean addMonkey(Monkey m) {
    boolean spaceAvailable = checkAvailability();
    if (spaceAvailable && m != null) {
      monkeys.add(m);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean removeMonkey(Monkey m) {
    if (!monkeys.contains(m)) {
      return false;
    } else {
      monkeys.remove(m);
      return true;
    }
  }

  @Override
  public List<Monkey> getMonkeyList() {
    return monkeys;
  }

  @Override
  public int getSize() {
    return 10;
  }

  @Override
  public String getLocation() {
    return "Isolation Unit: " + isolationUnit_id;
  }

  @Override
  public MonkeySpecies getSpecies() {
    MonkeySpecies species = MonkeySpecies.EMPTY;
    if (monkeys.isEmpty()) {
      return species;
    } else {
      for (Monkey monkey : monkeys) {
        species = monkey.getMonkeySpecies();
        if (species == MonkeySpecies.OTHER) {
          continue;
        } else {
          break;
        }
      }
    }
    return species;
  }

  /**
   * Helper method to check the space availability in the Isolation Unit.
   */
  private boolean checkAvailability() {
    return monkeys.size() == 0;
  }
}
