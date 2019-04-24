/*This class consists of the different commands that are to be selected based on the location and the action performed by the player*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class CommandSelector {
	
	
	public CommandSelector() {
		
	}
	
	//This method returns the command based on the plot type given.
	public Command getCommandInstance(String plotType, MoneyTransaction transact, String command) {
		
		switch(plotType) {
		
		case "Avenue":
			return getAvenueCommand(command, transact);
		case "Electricity":
		case "RailRoad":
			return new BuySquare(transact);
		case "IncomeTax":
			return new PayTax(transact);
		default:
			return null;
		
		}
		
	}
	
	//This method returns whether a player wants to buy the plot or build a house when he lands on an avenue plot.
	public Command getAvenueCommand(String Command, MoneyTransaction transact) {
		
		switch(Command) {
		
		case "Buy":
			return new BuySquare(transact);
		case "Build":
			return new BuildHouse(transact);
			
		default:
			return null;
		}
	}

}
