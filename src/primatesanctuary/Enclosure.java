package primatesanctuary;

import java.util.ArrayList;
import java.util.List;

/**
 * Enclosure is a type of Housing which is available for the troops of monkeys
 * in the Sanctuary.
 */
public class Enclosure implements Housing {

  private final String enclosureId;
  private static int counter;
  private final int enclosureSize;
  private final List<Monkey> monkeys = new ArrayList<Monkey>();

  /**
   * Constructs an Enclosure and sets the Id and size for it.
   *
   * @param enclosureSize the size of the enclosure.
   */
  public Enclosure(int enclosureSize) {
    counter++;
    this.enclosureId = "E" + counter;
    this.enclosureSize = enclosureSize;
  }

  @Override
  public boolean isEnclosure() {
    return true;
  }

  @Override
  public boolean addMonkey(Monkey m) {
    if (m != null) {
      boolean spaceAvailable = checkAvailability(m);
      if (spaceAvailable  && !(monkeys.contains(m))) {
        monkeys.add(m);
        return true;
      }
    }
    return false;
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
    return enclosureSize;
  }

  @Override
  public String getLocation() {
    return "Enclosure: " + enclosureId;
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
   * Helper method to check the space availability in the Enclosure.
   */
  private boolean checkAvailability(Monkey newMonkey) {
    int occupiedArea = 0;
    int availableArea = this.enclosureSize;
    int requiredArea = 0;
    //get the Species of the new Monkey
    MonkeySpecies newMonkeySpecies = newMonkey.getMonkeySpecies();
    //get the Species of the monkeys in the enclosure
    MonkeySpecies enclosureSpecies = getSpecies();
    //if species do not match, then return incompatible types
    if (!(monkeys.isEmpty()) && newMonkeySpecies != enclosureSpecies) {
      return false;
    }
    //if species match, check if space is available
    if (!(monkeys.isEmpty())) {
      //find the area already occupied in the enclosure
      for (Monkey m : monkeys) {
        MonkeySize size = m.getMonkeySize();
        if (size == MonkeySize.LARGE) {
          occupiedArea = occupiedArea + 10;
        } else if (size == MonkeySize.MEDIUM) {
          occupiedArea = occupiedArea + 5;
        } else {
          occupiedArea = occupiedArea + 1;
        }
      }
    }
    //get the available area in the enclosure
    availableArea = enclosureSize - occupiedArea;
    MonkeySize newMonkey_size = newMonkey.getMonkeySize();
    //check if new monkey can fit in available area
    if (newMonkey_size == MonkeySize.LARGE) {
      requiredArea = 10;
    } else if (newMonkey_size == MonkeySize.MEDIUM) {
      requiredArea = 5;
    } else {
      requiredArea = 1;
    }
    //return true/false based on available area
    return (requiredArea <= availableArea);
  }

  /**
   * Produces a sign for a given enclosure.
   *
   * @return String that lists each individual monkey in the enclosure with its details
   *         (name, sex, and favorite food)
   */
  protected String generateSign() {
    String enclosure_sign = "Enclosure: " + enclosureId
            + "\n-----------------------------------------";
    if (monkeys.size() == 0) {
      enclosure_sign = enclosure_sign + "\nEnclosure is Empty";
    }
    //append data for each monkey to the Enclosure Sign
    else {
      for (Monkey m : monkeys) {
        enclosure_sign = enclosure_sign + "\nName: " + m.getMonkeyName() + "\nSex: "
                + m.getMonkeyGender() + "\nFavorite Food: " + m.getFavFood()
                + "\n-----------------------------------------";
      }
    }
    return enclosure_sign;
  }

}
