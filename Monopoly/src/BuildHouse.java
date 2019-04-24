/*This class contains methods which are called when a player wants to build a house in the plot he owns*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/


public class BuildHouse extends Command {

	//Constructor
	public BuildHouse(MoneyTransaction transact) {
		super(transact);
	}

	/*This method overrides the parent class(Command) method to perform building house action. If all the parameters are satisfied, then the method returns true
	which means that the player can build a house.*/
	public String execute(Player player,Board board, Banker banker,GetCardFactory getCard) throws MyException{
		
		String description="";
		
			if(player.getCurrentPlotCard() == null)
			{
				throw new MyException("You can't build house without buying the plot");
			}
		
			int maxHouses=((Avenue)player.getCurrentPlotCard()).getMaxHousesCanBeBuilt();
			int noOfHousesBuilt = ((AvenuePlot)board.getPlots()[player.getCurrentPlot()-1]).getNoOfHousesBuilt();
			int costToBuildHouse= ((Avenue)player.getCurrentPlotCard()).getCostToBuildHouse();
			
			boolean status = false;
			
			if(maxHouses>noOfHousesBuilt && player.getBalance()>costToBuildHouse) {
				transact.performTransaction(player, banker, costToBuildHouse );
				noOfHousesBuilt+=1;
				description="You Built a house on this plot";
				((AvenuePlot)board.getPlots()[player.getCurrentPlot()-1]).setNoOfHousesBuilt(noOfHousesBuilt);
				
				status = true;
			}
			
			return description;	
	}

}
