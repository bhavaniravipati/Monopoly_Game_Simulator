# MONOPOLY GAME SIMULATOR

## Project Title  <br/>
Monopoly Muggles - Simulating Monopoly game using OO design principles<br/>

## Project Members <br>
###### Bhavani Rishitha Ravipati - 109246465 <br/>
###### Priyanka Sundaram - 109265722 <br/>
###### Priyanka Umesh Pandit Tailapur - 109259683 <br/>
###### Reshma Chowdary Morampudi - 109258663 <br/>

<a href="https://youtu.be/QjQAZry7964" target="_blank"><img src="https://j.gifs.com/lx2Wy6.gif" width="240" height="180" border="10" /></a>

## Basic Overview <br/>
Monopoly is a multi-person board game where players roll dice to move around the game board. In our system, we are simulating a smaller version of the real-world game through a web application. This simulated version is a two player game with a reduced board that contains 24 plots in total. This board captures most of the different plot types present in the original monopoly board.  <br/>

## UI Files <br/>
There are 4 files related to User Interface placed in WEB CONTENT Folder <br/>
###### 1. index.jsp <br/>
This file consists of code to the landing page of the application where players are provided with a start button to enter to the next page (login) where players can enter their names <br/>

###### 2. login.jsp <br/>
This file consists of code to the second page of the application where players are provided with text boxes to enter their names and once they click on the start button, they land on main board <br/>

###### 3. monopoly.jsp <br/>
This file consists of code to the main page of the application where players are provided with buttons to roll die, end their turn, buy plots and build houses. There are 24 tiles depicting go cell, jail, avenues, railroads, community chest and chance cards, electricity, income tax, and free parking plot along with their details<br/>

###### 4. winner.jsp <br/>
This is the final page of the application where winners name is displayed<br/>

## Backend Files <br/>
There are 33 files related to Backend placed in src Folder <br/>
###### 1. Action.java
This class defines the actions that a player can perform based on his current location on the board <br/>

###### 2. Avenue.java
This class contains details about the Avenue Plots <br/>

###### 3. AvenuePlot.java
This class extends Plots class and has details about 10 Avenue plots namely RedWood Ave, Rainbow Ave, RockMont Ave, BlueBerry Ave, BlackHawk Ave, GrapeWood Ave, GoldHill Ave, Glacier Ave, Yale Ave, YellowPine Ave <br/>

###### 4. Banker.java
This is a Singleton class which creates a Banker instance <br/>

###### 5. Board.java
This is a Singleton class which creates a Board instance. Board consists of Plots <br/>

###### 6. BuildHouse.java
This class contains methods which are called when a player wants to build a house in the plot he owns <br/>

###### 7. BuySquare.java
This class contains methods which are called when a player wants to buy a particular plot that he landed on <br/>

###### 8. CAndCCard.java
This class contains details about the Chance and Community Chest Plots. We have defined 10 chance and Community chest cards <br/>

###### 9. Cards.java
This abstract class is the parent class for the chance and community chest cards <br/>

###### 10. Chance.java
This class extends Plots class and has details about Chance plot on the board <br/>

###### 11. Command.java
This abstract class is the parent class for the different kinds of commands that the player has to perform like Buy and Build <br/>

###### 12. CommandSelector.java
This class consists of the different commands that are to be selected based on the location and the action performed by the player <br/>

###### 13. CommunityChest.java
This class extends Plots class and has details about Community Chest plot on the board <br/>

###### 14. Dice.java
This class contains the action related to Dice <br/>

###### 15. Electricity.java
This class contains details about the Electricity Plot <br/>

###### 16. ElectricityPlot.java
This class extends Plots class and has details about Free Parking plot on the board <br/>

###### 17. FreeParking.java
This class extends Plots class and has details about Free Parking plot on the board<br/>

###### 18. GameController.java
This class defines the game start, stop and passing go conditions <br/>

###### 19. GameSimulator.java
This class acta as a simulator for the monopoly game which acts as link between monopoly controller class and the logic of the code <br/>

###### 20. GetCardFactory.java
This class generates card objects of type Avenue, Electricity, RailRoad, Chance and Community Chest <br/>

###### 21. Go.java
This class extends Plots class and has details about Go cell on the board <br/>

###### 22. GoToJail.java
This class extends Plots class and has details about Go To Jail plot on the board <br/>

###### 23. IncomeTax.java
This class extends Plots class and has details about IncomeTax plot on the board <br/>

###### 24. MoneyTransaction.java
This class is define the transactions performed as part of the game <br/>

###### 25. MonopolyController.java
This class acts as a controller in the MVC architecture which connects the view and the business logic. This class receives requests from the UI and directs these requests to the appropriate logic of the code and send the responses to the UI <br/>

###### 26. MoveToSquare.java
This class consists of the methods which are to be executed whenever a player wants to move within the board because of a chance or community chest card <br/>

###### 27. MyException.java
This class is defined to throw user defined exceptions <br/>

###### 28. PayTax.java
This class contains methods which are called when a player lands on pay tax plot <br/>

###### 29. Player.java
This class keeps track of all Player actions <br/>

###### 30. Plots.java
This abstract class is the parent class for the different kind of plots on the monopoly board which includes AvenuePlot, RailRoadPlot, ElectricityPlot, Free Parking, Community Chest & Chance, Income Tax, Go cell, Go To Jail and Visit Jail. This class has methods that help us to set and get the plot number and plot name of these plots <br/>

###### 31. RailRoad.java
This class contains details about the RailRoad Plots <br/>

###### 32. RailRoadPlot.java
This class extends Plots class and has details about 4 RailRoad plots on the board <br/>

###### 33. VisitJail.java
This class extends Plots class and has details about Visit Jail plot on the board <br/>

## Installation Notes <br/>
###### 1. Install Eclipse <br/>
###### 2. Install Apache Tomcat Server <br/>
###### 3. Add required external jar files - javax.servlet.jsp.jstl-1.2.1.jar, javax.servlet.jsp.jstl-api-1.2.1.jar <br/>

## Execution Process <br/>
###### Click on the project and select Run As-> Run on server <br/>
