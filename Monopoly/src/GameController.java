/*This class defines the game start, stop and passing go conditions*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class GameController {

	public GameController() {
		
	}
	
	//This method defines the stop conditions. Here we stop the game if either of the players have below $50 or the number of turns reach 50.
	public boolean stop(Player player1, Player player2, int numberOfTurns) {
			
			if(player1.getBalance()<=50 || player2.getBalance()<=50 || numberOfTurns==50)
			{
				return true;
			}
			
			return false;
	}
	
	//This method returns the winner. Whichever player has more money wins. If there is a tie, the player 1 is declared as winner.
	public Player winner(Player player1, Player player2) {
		
		if(player1.getBalance()>=player2.getBalance()) {
			return player1;
		}
		
		return player2;	
	}
	
	//This method is used to check if the player passed the Go cell and returns true if he has passed or landed on go.
	public boolean checkGo(Player player, int diceNumber) {
		
		int currPlot = player.getCurrentPlot();
		boolean status = false;
		
		int nextLocation = currPlot+diceNumber;
		
		if(nextLocation > 24 ) {
			status = true;
		}
		
		return status;
	}
	
}
