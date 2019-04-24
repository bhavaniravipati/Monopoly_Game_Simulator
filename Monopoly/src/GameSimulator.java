/*This class acta as a simulator for the monopoly game which acts as link between monopoly controller class and the logic of the code*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

import java.util.ArrayList;

public class GameSimulator {
	
	//Key attribute which defines the number rolled by the Dice
	int diceNumber;
	
	/*This method returns the players list to the monopoly controller. This method keeps track of the current player for each turn of the game.*/
	public ArrayList<Player> first(int numberOfTurns,Player player1,Player player2,GameController gc)
	{
		ArrayList<Player> playerList = new ArrayList<Player>();
		
		if(numberOfTurns < 50 && !gc.stop(player1, player2, numberOfTurns)) 
		{
				
				// choose player
				Player curPlayer = null;
				Player player = null;
				
				//Even turn, current player is Player1. Odd turn current player is player2
				if(numberOfTurns%2 == 0) 
				{
					curPlayer = player1;
					player = player2;
				}
				else 
				{
					curPlayer = player2;
					player = player1;
				}
				playerList.add(curPlayer);
				playerList.add(player);
		}
	return playerList;
	}
	
	/*When a player lands on Go cell or Passes Go cell when he throws a dice, he has to collect $100 from the Bank. 
	This method directs this transaction and also updates the current player's location*/
	public void second(Player curPlayer, Player player, Dice dice, Banker banker, Board board, MoneyTransaction transact,GameController gc) {
		diceNumber = curPlayer.rollDice(dice);
		
		if(gc.checkGo(curPlayer, diceNumber)) {
			transact.performTransaction(banker, curPlayer, 100);
		}
		
		// Update location
		curPlayer.updateLocation(diceNumber);

	}
	
	//This method is called when a player wants to buy a plot, build a house. And also, If the player lands on Chance, Community Chest, Income Tax or Go To Jail plots
	public String run(String command, int numberOfTurns, Player curPlayer, Player player, Banker banker,Board board, Dice dice,GameController gc, Action action, MoneyTransaction transact, GetCardFactory getCard) {
			
			try {
				
				return curPlayer.performAction(action, player, banker, transact, command, board,getCard);	
			}
			catch(MyException e){
				return "Caught the exception";
				
				//System.out.println(e);
			}
		
	}
	
	//This method returns the name of the winner by checking the possible chances of declaring a player as a winner.
	public String stop(Player curPlayer, Player player, GameController gc) {

		String name = gc.winner(curPlayer, player).getName();
		
		return name;
		
	}
}

