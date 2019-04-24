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
It is a 2 player game with the maximum number of turns per player reduced to 25<br/>
The properties that a player can hold, apart from plots, are limited only to houses that can be built on some of the plots that he owns<br/>
The number of chance and community cards are limited to 5 each<br/>
Money that each player receives initially is $1500<br/>
The salary a player receives as he passes “GO” cell is $100<br/>
The number of houses that can be built in a plot by a player is limited to 2<br/>
The initial amount with the banker is $5000<br/>

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
###### Action.java
This class defines the actions that a player can perform based on his current location on the board <br/>

###### Avenue.java
This class contains details about the Avenue Plots <br/>

###### AvenuePlot.java
This class extends Plots class and has details about 10 Avenue plots namely RedWood Ave, Rainbow Ave, RockMont Ave, BlueBerry Ave, BlackHawk Ave, GrapeWood Ave, GoldHill Ave, Glacier Ave, Yale Ave, YellowPine Ave <br/>

###### Banker.java
This is a Singleton class which creates a Banker instance <br/>

###### Board.java
This is a Singleton class which creates a Board instance. Board consists of Plots <br/>

###### BuildHouse.java
This class contains methods which are called when a player wants to build a house in the plot he owns <br/>

###### BuySquare.java
This class contains methods which are called when a player wants to buy a particular plot that he landed on <br/>

###### CAndCCard.java
This class contains details about the Chance and Community Chest Plots. We have defined 10 chance and Community chest cards <br/>

###### Cards.java
This abstract class is the parent class for the chance and community chest cards <br/>

###### Chance.java
This class extends Plots class and has details about Chance plot on the board <br/>

###### Command.java
This abstract class is the parent class for the different kinds of commands that the player has to perform like Buy and Build <br/>

###### CommandSelector.java
This class consists of the different commands that are to be selected based on the location and the action performed by the player <br/>

###### CommunityChest.java
This class extends Plots class and has details about Community Chest plot on the board <br/>

###### Dice.java
This class contains the action related to Dice <br/>

###### Electricity.java
This class contains details about the Electricity Plot <br/>

###### ElectricityPlot.java
This class extends Plots class and has details about Free Parking plot on the board <br/>

###### FreeParking.java
This class extends Plots class and has details about Free Parking plot on the board<br/>

###### GameController.java
This class defines the game start, stop and passing go conditions <br/>

###### GameSimulator.java
This class acta as a simulator for the monopoly game which acts as link between monopoly controller class and the logic of the code <br/>

###### GetCardFactory.java
This class generates card objects of type Avenue, Electricity, RailRoad, Chance and Community Chest <br/>

###### Go.java
This class extends Plots class and has details about Go cell on the board <br/>

###### GoToJail.java
This class extends Plots class and has details about Go To Jail plot on the board <br/>

###### IncomeTax.java
This class extends Plots class and has details about IncomeTax plot on the board <br/>

###### MoneyTransaction.java
This class is define the transactions performed as part of the game <br/>

###### MonopolyController.java
This class acts as a controller in the MVC architecture which connects the view and the business logic. This class receives requests from the UI and directs these requests to the appropriate logic of the code and send the responses to the UI <br/>

###### MoveToSquare.java
This class consists of the methods which are to be executed whenever a player wants to move within the board because of a chance or community chest card <br/>

###### MyException.java
This class is defined to throw user defined exceptions <br/>

###### PayTax.java
This class contains methods which are called when a player lands on pay tax plot <br/>

###### Player.java
This class keeps track of all Player actions <br/>

###### Plots.java
This abstract class is the parent class for the different kind of plots on the monopoly board which includes AvenuePlot, RailRoadPlot, ElectricityPlot, Free Parking, Community Chest & Chance, Income Tax, Go cell, Go To Jail and Visit Jail. This class has methods that help us to set and get the plot number and plot name of these plots <br/>

###### RailRoad.java
This class contains details about the RailRoad Plots <br/>

###### RailRoadPlot.java
This class extends Plots class and has details about 4 RailRoad plots on the board <br/>

###### VisitJail.java
This class extends Plots class and has details about Visit Jail plot on the board <br/>

## Execution Process <br/>
