/*This class defines the actions that a player can perform based on his current location on the board*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/
public class Action {

	public Action() {
		
	}
	
	//This method performs actions based on the current plot of the player.
	public String performAction(Player player1, Player player2, Banker banker, MoneyTransaction transact, String command,Board board,GetCardFactory getCard) throws MyException {
		
		String description="";
		switch(player1.getCurrentPlot()) {
		
		case 1:
			transact.performTransaction(banker, player1, 100);
			return "You got $100 from Bank";
		case 2:
		case 4:
		case 6:
		case 9:
		case 10:
		case 14:
		case 16:
		case 18:
		case 22:
		case 23:
			description=new CommandSelector().getCommandInstance("Avenue",transact, command).execute(player1, board, banker,getCard);
			
			break;
		case 3:
		case 12:
		case 15:
		case 24:
			String card=performCCardActions(getCard, player1, player2, transact, banker);
			return card;
		case 5:
		case 11:
		case 17:
		case 21:
			description =new CommandSelector().getCommandInstance("RailRoad", transact, command).execute(player1, board, banker,getCard);
			break;
		case 7:
			return "";
		case 8:
			description=new CommandSelector().getCommandInstance("Electricity", transact, command).execute(player1, board, banker,getCard);
			break;
		case 13:
			return "";
		case 19:
			description=new MoveToSquare().execute(player1,-12);
			break;
		case 20:
			description=new CommandSelector().getCommandInstance("IncomeTax", transact, command).execute(player1, board, banker,getCard);
			break;
		default:
			return "";
		}
		return description;
		
	}
	
	//This method performs actions based on the generated chance and community chest cards.
	public String performCCardActions(GetCardFactory getCard, Player player1,Player player2, MoneyTransaction transact, Banker banker)
	{
		CAndCCard card=getCard.getCAndCCard();
		String description=card.getDescription();
		
		switch(description) 
		{
		case "Move To Go":
			new MoveToSquare().execute(player1);
			transact.performTransaction(banker, player1, 100);
			break;
		case "Bank error in your favor. Collect $125":
			transact.performTransaction(banker, player1, 125);
			break;
		case "You have won a CrossWord Competition. Collect $100":
			transact.performTransaction(banker, player1, 100);
			break;
		case "You have been elected as the Chairman of the Board. Pay each player $50":
			player1.performTransaction(player2, 50);
			break;
		case "Building loan matures. Collect $150 from Bank":
			transact.performTransaction(banker, player1, 150);
			break;
		case "Go To Jail. Do not pass Go. Do not collect $100":
			int jumps = player1.getCurrentPlot() - 7;
			new MoveToSquare().execute(player1,-jumps);
			break;
		case "You inherit $100":
			transact.performTransaction(banker, player1, 100);
			break;
		case "Hospital fees: Pay $50":
			transact.performTransaction(player1, banker, 50);
			break;
		case "Grand Opera Night: Collect $50 from every player for opening night seats":
			player2.performTransaction(player1, 50);
			break;
		case "You are assessed for street repairs. Pay $40 per plot":
			transact.performTransaction(player1, banker, (int)40*player1.getCards().size());
			break;
		default:
			return "";
		}
		return description;
	}

}
