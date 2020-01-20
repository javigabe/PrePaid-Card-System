# **Pre-Paid Card System**

## **Content of the project root**
- src -> Contains source code and tests
- pom.xml -> config file for the project
- README.md -> file with project description
- .gitignore -> ignored files by the repository

## **Instructions**

To execute all the tests you may have Maven installed and execute the command "mvn test".
To launch the graphic interface run "PrePaidCard.java" in src/main/views package.

## **Content src/main/model**
- PrePaidCardManager: implements the interface PrePaidCardInterface. Is the manager, it controls the cards and has the following methods to do it.

  * buyCard: Method to buy a card, it checks if the pin's format is correct and then register the card in the system.
  * chargeCard: Checks if the card is already in the system and call the card method to charge it (charge). It saves the movement in a database and returns the final balance.
  * payCard: Checks if the card is already in the system and call the card method to pay with it (pay). It saves the movement in a database and returns the final balance.
  * changePin: Checks if the card is already in the system and if the new pin's format is correct, then call the card method to change the pin (changePin).
  * consultMovements:  Checks if the card is already in the system and call the card method to consult the movements (consultMovements). Return the list of the movements done with the card.
  * consultBalance: Checks if the card is already in the system and call the card method to consult the balance (consultBalance). Return the balance.
  * It has private methods to store and read cards from the storage file


- Card: the class to save the cards and operate with them. It has the following methods.

  * consultBalance: Checks if the pin is correct and returns the card balance.
  * charge: Checks if the pin is correct and if the card is not expirated and then charges the card.
  * pay: Checks if the pin is correct if the card is not expired and if there is enough money. Then pays with the card.
  * changePin: Checks if the old pin was correct and then changes it to the new one.
  * consultMovements: Checks if the pin is correct and returns a list of the movements.
  * checkPin: Auxiliar method to check if the pin is correct. The other methods call this one to check it.
  * getId: returns the card id.
  * getBalance: returns the card balance.
  * getOwner: returns the card owner.
  
  
- Cipher: hash function to cipher the card's pins.

- Event: class to save the events made with a card.

- Exceptions.

## **Content src/main/controllers**

- Controller: performs the operations requested by the graphic interface.

## **Content src/main/views**

- PrePaidCard: launches the system.
- FrameManager: contains all the JFrame structure.


## **Content src/test**
- AppTest -> file containing all the tests for the project
