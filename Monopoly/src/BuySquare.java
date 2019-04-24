/*This class contains methods which are called when a player wants to buy a particular plot that he landed on*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class BuySquare extends Command{

	//Constructor
	public BuySquare(MoneyTransaction transact) {
		super(transact);
	}

	/*This method overrides the parent class(Command) method to perform buying plot action. If the plot is not bought, then the method performs transactions
	 to buy plot, update owner and update the set of cards the player owns and returns true on completion or false if any condition is not satisfied.*/
	public String execute(Player player, Board board, Banker banker, GetCardFactory getCard) {
		
			int plotNumber=player.getCurrentPlot();
			boolean status=false;
			switch(plotNumber)
			{
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
				AvenuePlot plot1 = (AvenuePlot) board.getPlots()[plotNumber-1];
				
				//Condition to check whether the current avenue plot is bought or not.
				if((player.getBalance()>=plot1.getPriceOfPlot() && plot1.getOwner()==null))
				{
					transact.performTransaction(player, banker,plot1.getPriceOfPlot());
					plot1.setOwner(player.getName());
					player.updateCards(getCard);
					status = true;
				}
				break;
			case 5:
			case 11:
			case 17:
			case 21:
				RailRoadPlot plot2=(RailRoadPlot)board.getPlots()[plotNumber-1];
				
				//Condition to check whether the current railroad plot is bought or not.
				if(player.getBalance()>=plot2.getPriceOfRailRoad() && plot2.getOwner()==null)
				{
					transact.performTransaction(player, banker, plot2.getPriceOfRailRoad());
					plot2.setOwner(player.getName());
					player.updateCards(getCard);
					status=true;
				}
				
				break;
			case 8:
				ElectricityPlot plot3=(ElectricityPlot)board.getPlots()[plotNumber-1];
				
				//Condition to check whether the current electricity plot is bought or not.
				if(player.getBalance()>=plot3.getPriceOfElectricityPlot() && plot3.getOwner()==null)
				{
					transact.performTransaction(player, banker, plot3.getPriceOfElectricityPlot());
					plot3.setOwner(player.getName());
					player.updateCards(getCard);
					status=true;
				}
			
				break;
			
			default:
				break;
				
			}
			return "You bought this plot";
	}
	
	

}
