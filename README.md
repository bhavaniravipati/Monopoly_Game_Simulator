# MONOPOLY GAME SIMULATOR

## Project Title  <br/>
Monopoly Muggles - Simulating Monopoly game using OO design principles<br/>

## Project Members <br>
Bhavani Rishitha Ravipati       109246465 <br/>
Priyanka Sundaram               109265722 <br/>
Priyanka Umesh Pandit Tailapur  109259683  <br/>
Reshma Chowdary Morampudi	      109258663 <br/>

## Basic Overview <br/>
Monopoly is a multi-person board game where players roll dice to move around the game board. In our system, we are simulating a smaller version of the real-world game through a web application. This simulated version is a two player game with a reduced board that contains 24 plots in total. This board captures most of the different plot types present in the original monopoly board.  <br/>

## List of Features <br/>
Following are the features of our game board and the nature of players: <br/>
There are 24 plots in total<br/>
1. It is a 2 player game with the maximum number of turns per player reduced to 25<br/>
2. The properties that a player can hold, apart from plots, are limited only to houses that can be built on some of the plots that he owns<br/>
3. The number of chance and community cards are limited to 5 each<br/>
4. Money that each player receives initially is $1500<br/>
5. The salary a player receives as he passes “GO” cell is $100<br/>
6. The number of houses that can be built in a plot by a player is limited to 2<br/>
7. The initial amount with the banker is $5000<br/>

## Rules of the game <br/>
1. Roll a dice <br/>
2. Move the player’s token to the respective position as rolled by the dice <br/>
3. Perform the action specific to the plot that the token landed on <br/>
4. If the player lands in a plot which is an avenue, the player can either buy it, build a house or pay rent if the other player has already bought it. If a player buys a plot, the system will assign a plot card to the player. Plot card includes information related to the plot such as cost and rent of the plot, the number of houses that can be built on the plot, cost to build a house, etc <br/>
5. If the player owns a plot, he is allowed to build a house on that plot <br/>
6. If the player lands in a plot which is either Chance or Community Chest, the system will give him a random card and he should perform an action based on assigned card’s instruction <br/>
7. If the player lands in a plot which has railroad/utilities, he can either buy or pay rent if the other player owns it <br/>
8. If the player lands in a plot which has an Income tax, he has to pay income tax of $50 to the banker <br/>
9. If the player lands in a plot which has Jail or Free Parking, he does not perform any action <br/>
10. If the player lands in a plot which has Go to Jail, then he must backtrack and go to the Visit Jail plot <br/>
11. If the player passes by Go plot after one complete round, then he will collect $100 salary from the banker <br/>

## UI Files <br/>
There are 4 files related to User Interface placed in WEB CONTENT Folder <br/>
###### 1. index.jsp <br/>
This file consists of code to the landing page of the application where players are provided with a start button to enter to the next page (login) where players can enter their names <br/>

###### 2. login.jsp <br/>
This file consists of code to the second page of the application where players are provided with text boxes to enter their names and once they click on the start button, they land on main board <br/>

###### 3. monopoly.jsp <br/>
This file consists of code to the main page of the application where players are provided with buttons to roll die, end their turn, buy plots and build houses <br/>
There are 24 tiles depicting go cell, jail, avenues, railroads, community chest and chance cards, electricity, income tax, and free parking plot along with their details<br/>

###### 4. winner.jsp <br/>
This is the final page of the application where winners name is displayed<br/>

## Backend Files <br/>
There are 4 files related to User Interface placed in SRC Folder <br/>
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

## Execution Process <br/>
