package primatesanctuary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents the data and operations happening in the Jungle Friends Primate Sanctuary.
 */
public class SanctuaryM implements Sanctuary {

  private int sanctuaryArea;
  private final List<Housing> housings;

  /**
   * Constructs a Sanctuary with Enclosures of size 50 sq mt and Isolation Units of 10 sq my each
   * using the counts passed in enclosure and isolation count parameters.
   *
   * @param enclosureCount     initial numbers of enclosures in the sanctuary.
   * @param isolationUnitCount initial numbers of isolation units in the sanctuary.
   * @throws IllegalArgumentException if enclosure count or isolation unit count is negative.
   */
  public SanctuaryM(int enclosureCount, int isolationUnitCount) {
    if (enclosureCount <= 0) {
      throw new IllegalArgumentException("Number of maximum Enclosures cannot be negative");
    }
    if (isolationUnitCount <= 0) {
      throw new IllegalArgumentException("Number of maximum Isolation Units cannot be negative");
    }
    this.sanctuaryArea = (50 * enclosureCount) + (10 * isolationUnitCount);
    this.housings = new ArrayList<>();
    for (int i = 0; i < enclosureCount; i++) {
      createEnclosure(50);
    }
    for (int i = 0; i < isolationUnitCount; i++) {
      createIsolationUnits();
    }
  }

  @Override
  public void increaseSanctuaryCapacity(int additionalSanctuaryArea) {
    if (additionalSanctuaryArea <= 0) {
      throw new IllegalArgumentException("Additional Sanctuary area cannot be 0 or negative.");
    }
    this.sanctuaryArea += additionalSanctuaryArea;
  }

  @Override
  public void createEnclosure(int size) throws IllegalStateException {
    if (getavailableAreaForExpansion() >= size) {
      Enclosure e = new Enclosure(size);
      housings.add(e);
    } else {
      throw new IllegalStateException("No new enclosures of this size can be added. "
              + "Sanctuary area limit reached.");
    }
  }

  @Override
  public void createIsolationUnits() throws IllegalStateException {
    if (getavailableAreaForExpansion() >= 10) {
      IsolationUnit i = new IsolationUnit();
      housings.add(i);
    } else {
      throw new IllegalStateException("No new Isolation Units can be added. "
              + "Sanctuary area limit reached.");
    }
  }

  /**
   * Helper method to return the empty space available in the sanctuary. To be used while adding
   * new enclosures and isolation units.
   */
  private int getavailableAreaForExpansion() {
    int occupiedSanctuaryArea = 0;
    int availableAreaForExpansion;
    //calculate area occupied by existing housings
    for (Housing h : housings) {
      occupiedSanctuaryArea = occupiedSanctuaryArea + h.getSize();
    }
    //calculate the area available for expansion in the sanctuary
    availableAreaForExpansion = sanctuaryArea - occupiedSanctuaryArea;
    return availableAreaForExpansion;
  }

  @Override
  public boolean checkSpaceAvailability() {
    for (Housing h : housings) {
      if (!h.isEnclosure()) {
        if (h.getMonkeyList().size() == 0) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public void addNewMonkey(String name, String gender, String size, String species,
                           String favFood, int weight, int age)
          throws IllegalStateException, IllegalArgumentException {
    //check if input string values are of proper format
    if (name.isEmpty() || !isInEnum(gender, MonkeyGender.class)
            || !isInEnum(size, MonkeySize.class) || !isInEnum(species, MonkeySpecies.class)
            || !isInEnum(favFood, FoodType.class)) {
      throw new IllegalArgumentException("String arguments contain some mistakes.");
    }
    //check if integer values are of proper specifications
    if (weight <= 0 || age < 0) {
      throw new IllegalArgumentException("Weight and Age cannot be negative.");
    }
    //check if any Isolation Unit is available for the new monkey
    boolean space_available = checkSpaceAvailability();
    //if isolation unit is available, do the following
    if (space_available) {
      //find the available isolation unit from the housing list
      for (Housing h : housings) {
        if (!h.isEnclosure()) {
          if (h.getMonkeyList().size() == 0) {
            //create a new monkey object for the empty isolation unit
            Monkey m = new Monkey(name, MonkeyGender.valueOf(gender), MonkeySize.valueOf(size),
                    MonkeySpecies.valueOf(species), FoodType.valueOf(favFood), weight, age,
                    new Date());
            h.getMonkeyList().add(m);
            break;
          }
        }
      }
    }
    //if no isolation unit is available, throw the exception
    else {
      throw new IllegalStateException("Monkey cannot be added as all Isolation Units are full.");
    }
  }

  @Override
  public void moveMonkey(Monkey m, Housing dest)
          throws IllegalStateException, IllegalArgumentException {
    boolean isMoveToDestSuccess = false;
    boolean monkeyfound = false;
    //check if destination is valid
    if (!housings.contains(dest)) {
      throw new IllegalArgumentException("Destination location does not exist.");
    }
    //Check if monkey exists in any Housings
    for (Housing h : housings) {
      //check if monkey exists in current housing
      for (Monkey m1 : h.getMonkeyList()) {
        //if monkey is found in current enclosure, begin the process of moving it to destination
        if (m1.getMonkeyId() == m.getMonkeyId()) {
          monkeyfound = true;
          //move the monkey to destination location
          isMoveToDestSuccess = dest.addMonkey(m);
          //if monkey is moved successfully to destination, remove monkey data from source
          // location
          if (isMoveToDestSuccess) {
            h.removeMonkey(m);
          }
          //stop searching for the monkey in current housing
          break;
        }
      }
      if (isMoveToDestSuccess) {
        //stop searching for the monkey in other housings
        break;
      }
    }
    //if monkey was not found in any housing unit, throw exception
    if (!monkeyfound) {
      throw new IllegalArgumentException("Monkey was not found in any Isolation Units or"
              + " Enclosures.");
    }
    //if monkey was found but was not moved to destination, then throw exception
    if (!isMoveToDestSuccess) {
      throw new IllegalStateException("Monkey could not be moved to the Destination because "
              + "capacity is full.");
    }
  }

  @Override
  public void autoMoveMonkeyToEnclosure(Monkey m)
          throws IllegalStateException, IllegalArgumentException {
    boolean monkeyadded = false;
    boolean monkeyfound = false;
    boolean monkeyinenclosure = false;
    //check if monkey exists in any housing unit
    for (Housing h : housings) {
      for (Monkey m1 : h.getMonkeyList()) {
        if (m1.getMonkeyId() == m.getMonkeyId()) {
          monkeyfound = true;
          //if monkey is already in an enclosure then skip
          if (monkeyfound && h.isEnclosure()) {
            monkeyinenclosure = true;
            break;
          }
          //find a suitable enclosures for the monkey
          for (Housing e : housings) {
            if (e.isEnclosure() && !(e.getLocation().equals(h.getLocation()))) {
              //skip empty enclosures, to be used if no other suitable enclosure is found
              if (e.getMonkeyList().size() == 0) {
                continue;
              }
              //add monkey to the new enclosure
              monkeyadded = e.addMonkey(m);
              //if monkey is successfully added to enclosure, stop searching for other enclosures
              if (monkeyadded) {
                break;
              }
            }
          }
          //if no suitable enclosure was found, then check if any empty enclosure is available
          if (!monkeyadded) {
            //check if any empty enclosure is available
            for (Housing e1 : housings) {
              //add monkey to the empty enclosure
              if (e1.isEnclosure() && e1.getMonkeyList().size() == 0) {
                monkeyadded = e1.addMonkey(m);
                if (monkeyadded) {
                  break;
                }
              }
            }
          }
          //if monkey is successfully added to an enclosure, remove the monkey record from
          // the source housing location
          if (monkeyadded) {
            h.removeMonkey(m);
            break;
          }
        }
      }
      if (monkeyinenclosure) {
        break;
      }
    }
    //if monkey was found, but could not be moved to an enclosure
    if (monkeyfound && !monkeyinenclosure && !monkeyadded) {
      throw new IllegalStateException(String.format("Monkey(%s) cannot be moved as all compatible "
              + "Enclosures are full.", m.getMonkeyName()));
    }
    //if monkey was not found in any housing unit
    else if (!monkeyfound) {
      throw new IllegalArgumentException("Monkey was not found in any Housing Unit.");
    }
  }

  @Override
  public void autoMoveMonkeyToIsolationUnit(Monkey m)
          throws IllegalStateException, IllegalArgumentException {
    boolean monkeyadded = false;
    boolean monkeyfound = false;
    //check if monkey exists in any housing unit
    for (Housing h : housings) {
      for (Monkey m1 : h.getMonkeyList()) {
        if (m1.getMonkeyId() == m.getMonkeyId()) {
          monkeyfound = true;
          //find a/another suitable isolation unit for the monkey
          for (Housing i : housings) {
            if (!i.isEnclosure() && !(i.getLocation().equals(h.getLocation()))) {
              //add monkey to the new isolation unit
              monkeyadded = i.addMonkey(m);
              //if monkey is successfully added to the isolation unit, stop searching for others
              if (monkeyadded) {
                break;
              }
            }
          }
          //if monkey is successfully added to a new isolation unit, remove the monkey record from
          // the source housing location
          if (monkeyadded) {
            h.removeMonkey(m);
            break;
          }
        }
      }
    }
    //if monkey was found, but could not be moved to an isolation unit
    if (monkeyfound && !monkeyadded) {
      throw new IllegalStateException("Monkey cannot be moved as all Isolation Units are full.");
    }
    //if monkey was not found in any housing unit
    else if (!monkeyfound) {
      throw new IllegalArgumentException("Monkey was not found in any Housing Unit.");
    }
  }

  @Override
  public List<String> getSpeciesList() {
    List<String> speciesList = new ArrayList<>();
    //for each value of monkey species do the following
    for (MonkeySpecies s : MonkeySpecies.values()) {
      String locations;
      //Skip if monkey species is Empty
      if (s != MonkeySpecies.EMPTY) {
        //get the locations where current species is housed
        locations = getSpeciesLocations(s);
        String speciesLocation = s + " - " + locations;
        //add the species and its locations to the list
        speciesList.add(speciesLocation);
      }
    }
    //sort the list alphabetically
    speciesList.sort(String::compareToIgnoreCase);
    return speciesList;
  }

  @Override
  public String lookUpSpeciesLocation(MonkeySpecies s) {
    String locations;
    locations = getSpeciesLocations(s);
    return locations;
  }

  /**
   * Helper method to return the String of all locations where the input species is housed.
   */
  private String getSpeciesLocations(MonkeySpecies s) {
    String locations = "";
    //get list of housing unit for the species
    for (Housing h : housings) {
      if (s == h.getSpecies()) {
        locations += h.getLocation() + ", ";
      }
    }
    //if species does not exist in any location in the sanctuary, print this
    if (locations.isEmpty()) {
      locations = "This species is currently not housed in the Sanctuary.";
    }
    return locations;
  }

  @Override
  public List<String> getMonkeyList() {
    List<String> monkeyList = new ArrayList<>();
    for (Housing h : housings) {
      if (h.getMonkeyList().size() != 0) {
        for (Monkey m : h.getMonkeyList()) {
          String monkeyInfo = m.getMonkeyName() + " - " + h.getLocation();
          monkeyList.add(monkeyInfo);
        }
      }
    }
    monkeyList.sort(String::compareToIgnoreCase);
    return monkeyList;
  }

  @Override
  public List<String> createShoppingList() {
    List<String> foodList = new ArrayList<>();
    //for each food type check the quantity required
    for (FoodType f : FoodType.values()) {
      int foodquantity = 0;
      //check each Housing Unit
      for (Housing h : housings) {
        //check each monkey in the Housing Unit
        for (Monkey m : h.getMonkeyList()) {
          //check if current food item is favorite of current monkey
          if (f == m.getFavFood()) {
            //get the size of the monkey
            MonkeySize size = m.getMonkeySize();
            //allocate food quantity based on monkey's size
            foodquantity = foodquantity + getFoodRequirement(size);
          }
        }
      }
      //consolidate the food item quantity from all housing units
      String listItem = f + " - " + foodquantity + " gr";
      //add the food item and its quantity to the list
      foodList.add(listItem);
    }
    return foodList;
  }

  /**
   * Helper method to get the food quantity requirement based on monkey size.
   */
  private int getFoodRequirement(MonkeySize size) {
    if (size == MonkeySize.LARGE) {
      return 500;
    } else if (size == MonkeySize.MEDIUM) {
      return 250;
    } else {
      return 100;
    }
  }

  /**
   * Helper method used to check if a value belongs to the enum class.
   * Source: https://stackoverflow.com/questions/10199462/how-to-check-if-a-given-string-is-a-part
   * -of-any-given-enum-in-java
   */
  private <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
    for (E e : enumClass.getEnumConstants()) {
      if (e.name().equals(value)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String getEnclosureSign(Housing h) {
    if (h.isEnclosure()) {
      Enclosure e = (Enclosure) h;
      return e.generateSign();
    }
    return "Not an Enclosure.";
  }

  @Override
  public List<Housing> getHousingList() {
    return this.housings;
  }
}
