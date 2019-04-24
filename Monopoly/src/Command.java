/*This abstract class is the parent class for the different kinds of commands that the player has to perform like Buy and Build*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public abstract class Command 
{
	//Key attribute which contains the transaction object
	MoneyTransaction transact;
	
	//Constructor
	public Command(MoneyTransaction transact) 
	{
		this.transact=transact;
	}
	
	//Abstract method which is inherited by all the subclasses
	public abstract String execute(Player player, Board board, Banker banker, GetCardFactory getCard) throws MyException;
	
	
}

