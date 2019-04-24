/*This class extends Plots class and has details about 4 RailRoad plots on the board*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class RailRoadPlot extends Plots {
	
	//Key attribute which holds the name of player who owns the plot
	private String owner=null;
	
	//Key attribute which defines the price of the plot which the player has to pay to the bank to but it
	private int priceOfRailRoad;
	

	//Constructor
	public RailRoadPlot(int plotNumber, int priceOfRailRoad,String nameOfThePlot) {
		super(plotNumber,nameOfThePlot);
		this.priceOfRailRoad=priceOfRailRoad;
		
	}

	//Getter method to get the owner of the RailRoad plot
	public String getOwner() {
		return owner;
	}

	//Setter method to set the owner of the RailRoad plot
	public void setOwner(String owner) {
		this.owner = owner;
	}


	//Getter method to get the price of the RailRoad plot
	public int getPriceOfRailRoad() {
		return priceOfRailRoad;
	}

	//Setter method to set the price of the RailRoad plot
	public void setPriceOfRailRoad(int priceOfRailRoad) {
		this.priceOfRailRoad = priceOfRailRoad;
	}


	//This method overrides the parent(Plots) class method which indicates that the current player is landed on this plot.
	@Override
	public String printToScreen() {
		return "You are using RailRoad";
		
	}

}
