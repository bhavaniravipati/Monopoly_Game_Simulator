/*This class is define the transactions performed as part of the game*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class MoneyTransaction{

	//This method is called when player has to pay money to the banker
	public void performTransaction(Player player,Banker banker, int amount) {
		
		player.setBalance(player.getBalance()-amount);
		banker.setBalance(banker.getBalance()+amount);
		
	}	
	
	//This method is called when player gets money from banker
	public void performTransaction(Banker banker,Player player, int amount) {
		
		player.setBalance(player.getBalance()+amount);
		banker.setBalance(banker.getBalance()-amount);
		
	}
}
