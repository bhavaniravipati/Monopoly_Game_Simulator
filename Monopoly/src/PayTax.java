/*This class contains methods which are called when a player lands on pay tax plot*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class PayTax extends Command{

	//Constructor
	public PayTax(MoneyTransaction transact) {
		super(transact);
	}
	
	/*This method overrides the parent class(Command) method to perform transaction between player and banker. Player pays $50 to the bank upon landing on the 
	 pay tax plot*/
	public String execute(Player player,Board board,Banker banker, GetCardFactory getCard)
	{
		if(player.getBalance()>=50)
		{
			transact.performTransaction(player, banker, 50);
			return "You have to pay 50$ to the Bank";
		}
		else
			return "";
		
	}
	

}
