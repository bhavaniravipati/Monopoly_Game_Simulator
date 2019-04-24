/*This class keeps track of all Player actions*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/
import java.util.HashMap;

public class Player {
	
	//key attribute which holds the current location of the player that is set to 1 initially. 
	private int currentPlot = 1;
	
	//key attribute which holds the balance of the player that is set to 1500$ initially.
	private int balance = 1500;
	
	//Key attribute which holds the name of the player
	private String name;
	
	//key attribute which hold the cards owned by the player
	private HashMap<Integer,Cards> cards = new HashMap<Integer,Cards>();

	public Player()
	{
		
	}

	//This method returns the number rolled by the Dice
	public int rollDice(Dice dice)
	{
		return dice.throwDice();
	}
	
	//This method updates the location of the player based on the number rolled by him.
	public void updateLocation(int diceNumber)
	{
		if(Math.abs(currentPlot+diceNumber)>24)
			currentPlot= (Math.abs(currentPlot+diceNumber))%24;
		else
			currentPlot=Math.abs(currentPlot+diceNumber);
	}

	//Getter method to get the current location of the player
	public int getCurrentPlot() {
		return currentPlot;
	}

	//Getter method to get the balance of the player
	public int getBalance() {
		return balance;
	}

	//Setter method to set the balance of the player
	public void setBalance(int balance) {
		this.balance = balance;
	}

	//Getter method to get the name of the player
	public String getName() 
	{
		return name;
	}
	
	//Setter method to set the name of the player
	public void setName(String name)
	{
		this.name=name;
	}
	
	//This method updates the cards a player after he buys a plot 
	public void updateCards(GetCardFactory getCard)
	{
		cards.put(currentPlot,getCard.getCard(currentPlot));
	}
	
	//this method returns the cards owned by the player
	public HashMap<Integer,Cards> getCards()
	{
		return cards;
	}
	
	//Getter method to get the card of a particular plot
	public Cards getCurrentPlotCard() {
		
		return cards.get(currentPlot);
		
	}
	
	//This method is called when a player has to pay money to the other player
	public void performTransaction(Player player2,int amount) {
		
		
		this.setBalance(this.getBalance()-amount);
		player2.setBalance(player2.getBalance()+amount);
		
	}
	
	//This method is called based on the player's actions like Build house, Buy plot and also when he lands in Chance or Community Chest, Income Tax.
	public String  performAction(Action action, Player player2, Banker banker, MoneyTransaction transact, String command,Board board,GetCardFactory getCard) throws MyException {
			return action.performAction(this, player2, banker, transact, command, board,getCard);
	}
	
}
