### **Overview**
The system implemented using in this project
seeks to be the replacement for Jungle Friends Primate 
Sanctuary's paper based records.
The Jungle Friends Primate Sanctuary provides a permanent home and 
high-quality sanctuary care for New World primates who have 
been cast-off from the pet trade, retired from research, 
or confiscated by authorities. This program 
makes it possible to keep track of each primate in the sanctuary and 
their location.

### **List of features**
- Capability to expand the Sanctuary area and add new enclosures and isolation units.
- New monkeys entering the sanctuary get assigned to an isolation unit automatically.
- Capability to check the space availability in the Sanctuary.
- Monkeys can be assigned automatically to a compatible Enclosure based on their species and size requirements.
- Automated list can be generated for the food requirements of the Sanctuary's inhabitants.

### **How To Run**
In Command prompt/Terminal, navigate to the /res folder and run the 
command: **java -jar Project_Primates.jar**

### **How to Use the Program**
In order to use the various functionalities of the program,
a Sanctuary object needs to be created. The Example Run gives a
rundown of how the functionalities of the program work. You can 
use this program to add monkeys to the Sanctuary and move them
internally between different housing units. The program also
allows you to generate Lists of all inhabitants and their locations as well as to look up the 
location of a particular species if required.

### **Description of Examples**
Primates_Run1.txt:

- Initializing a sanctuary creates 2 enclosures and 3 isolation 
units of size 50 sq mt and 10 sq mt each, respectively. However, 
unless monkeys are added to the Sanctuary, an empty Sanctuary will 
display the List of Monkeys as follows:
```
---------------------------------------------
List of Monkeys in Sanctuary:[]

---------------------------------------------
List of Monkeys(with Location):

---------------------------------------------
```

- The initial step of adding monkeys to the Sanctuary assigns them to
Isolation Units. In such case, the output of Monkey List will be as follows:
```
---------------------------------------------
List of Monkeys(with Location):
Alex - Isolation Unit: I3
Chewy - Isolation Unit: I1
Momo - Isolation Unit: I2

---------------------------------------------
```
- The sanctuary provides the facility to move monkeys from Isolation Units to
compatible Enclosures. Once this is done, the output of monkey list will look as follow:
```
---------------------------------------------
List of Monkeys(with Location):
Alex - Enclosure: E2
Chewy - Enclosure: E1
Momo - Enclosure: E2

---------------------------------------------
```
- You can also check if there is space available for adding
new monkeys to the Sanctuary. The outputs for the same look as follows:
```
---------------------------------------------
Space is available for new monkeys.

---------------------------------------------
```
or
```
---------------------------------------------
Space is not available for new monkeys.

---------------------------------------------
```
- The program allows you to move a monkey to a specific destination (housing unit).
However, in case the destination housing unit is full following exception messages will be displayed.
```
---------------------------------------------
Move from Enclosure to an Isolation Unit
Exception Caught: Monkey could not be moved to the Destination because capacity is full.

---------------------------------------------
Move from Isolation Unit to an Enclosure
Exception Caught: Monkey could not be moved to the Destination because capacity is full.

---------------------------------------------
```
- The Sanctuary also allows you to add new enclosures and isolation units. However, this 
facility can be accessed only when empty space is available in the 
sanctuary. On adding new enclosures and/or isolation units, following 
output can be expected:
```
---------------------------------------------
Adding 3 new Enclosures(size:25,20,40 sqmt) and 8 new Isolation Units.
Added 3 new Enclosures(size:25,20,40 sqmt) and 8 new Isolation Units.
Space is available for new monkeys.

---------------------------------------------
```
However, if there is no space available, you get the following output:
```
---------------------------------------------
Adding a new Enclosure and Isolation Unit
Exception Caught: No new enclosures of this size can be added. Sanctuary area limit reached.
Exception Caught: No new Isolation Units can be added. Sanctuary area limit reached.

---------------------------------------------
```
- When moving monkeys from isolation units to enclosures, 
the species of the monkey needs to match with the destination enclosure. 
If there is no compatible enclosure available, the following message gets displayed:
```
---------------------------------------------
Exception Caught: Monkey(Mike) cannot be moved as all compatible Enclosures are full.
Exception Caught: Monkey(Jose) cannot be moved as all compatible Enclosures are full.

---------------------------------------------
```
- The sanctuary also provides functionality to auto generate lists like:

- Species(with their locations)
```
---------------------------------------------
Species List(with Location):
DRILL - Enclosure: E2, 
GUEREZA - This species is currently not housed in the Sanctuary.
HOWLER - Enclosure: E1, Enclosure: E3, 
MANGABEY - Isolation Unit: I10, Isolation Unit: I11, 
OTHER - This species is currently not housed in the Sanctuary.
SAKI - Enclosure: E5, 
SPIDER - Enclosure: E4, 
SQUIRREL - This species is currently not housed in the Sanctuary.
TAMARIN - This species is currently not housed in the Sanctuary.

---------------------------------------------
```
- Food Requirement List:
```
---------------------------------------------
Shopping List:
EGGS - 3050 gr
FRUITS - 1600 gr
INSECTS - 100 gr
LEAVES - 3350 gr
NUTS - 100 gr
SEEDS - 500 gr
TREESAP - 500 gr
OTHER - 0 gr

---------------------------------------------
```
- You can also generate signs for particular enclosures. The sign contains Enclosure Id and some details of its inhabitants:
```
---------------------------------------------
Enclosure Sign for Enclosure: E1
-----------------------------------------
Name: Chewy
Sex: MALE
Favorite Food: LEAVES
-----------------------------------------
Name: Mela
Sex: FEMALE
Favorite Food: SEEDS
-----------------------------------------
Name: Tupac
Sex: MALE
Favorite Food: LEAVES
-----------------------------------------
Name: Noah
Sex: MALE
Favorite Food: EGGS
-----------------------------------------
Name: Peanut
Sex: FEMALE
Favorite Food: FRUITS
-----------------------------------------
Name: Rick
Sex: MALE
Favorite Food: LEAVES
-----------------------------------------
Name: Rikki
Sex: MALE
Favorite Food: EGGS
-----------------------------------------
```
- Lastly, you can also use the look up functionality to find the locations 
of different species in the Sanctuary. A look up search for Howler species would
return the following result:
```
---------------------------------------------
Locations of Howler species: Enclosure: E1, Enclosure: E3, 
---------------------------------------------
```

### **Design Changes**
The earlier design of the system focussed on using the Housing units as a major drive for the 
program. however, on further considerations, it was decided to bring and drive the
major functionalities of the program from the Sanctuary.

### **Assumptions**
The program assumes few details in order to make the working less complicated. Few such assumptions 
are as follows:

- The Species of monkeys is restricted to drill, guereza, howler, mangabey, saki, spider, squirrel, 
and tamarin.
- Favorites among food types is restricted to eggs, fruits, insects, leaves, nuts, seeds, and tree 
sap. 
- Whenever a monkey is added to the sanctuary or needs to be moved to a 
different enclosure, it has to be sent to an isolation unit first.


### **Limitations**
The program has a few limitations that could be worked on in future versions:

- No tracking of monkeys that leave the Sanctuary.
- Monkeys of new species have to be clubbed under the 'OTHER' species category.
- Food requirements of types other than the mentioned ones 
are clubbed under the 'OTHER' category.


### **Citations**
Nil.