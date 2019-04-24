/*This class extends Plots class and has details about 10 Avenue plots namely RedWood Ave, Rainbow Ave, RockMont Ave, BlueBerry Ave, BlackHawk Ave, GrapeWood Ave, 
 GoldHill Ave, Glacier Ave, Yale Ave, YellowPine Ave*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class AvenuePlot extends Plots 
{
	//Key attribute which defines the color of the Avenue Plot
	private String color;
	
	//Key attribute which holds the name of player who owns the plot
	private String owner=null;
	
	//Key attribute which holds the number of houses built by the player who owns that particular plot
	private int noOfHousesBuilt=0;
	
	//Key attribute which defines the price of the Avenue plot which the player has to pay to the bank to but it
	private int priceOfPlot;
	
	//Constructor
	public AvenuePlot(int plotNumber, String color, int priceOfPlot, String nameOfThePlot) {
		super(plotNumber,nameOfThePlot);
		this.color=color;
		this.priceOfPlot=priceOfPlot;
	}

	
	//Getter method to get the color of the plot
	public String getColor() {
		return color;
	}

	//Setter method to set the color of the plot
	public void setColor(String color) {
		this.color = color;
	}

	//Getter method to get the owner of the plot
	public String getOwner() {
		return owner;
	}

	//Setter method to set the owner of the plot
	public void setOwner(String owner) {
		this.owner = owner;
	}

	//Getter method to get the number of houses built in the plot
	public int getNoOfHousesBuilt() {
		return noOfHousesBuilt;
	}

	//Setter method to set the number of houses built in the plot
	public void setNoOfHousesBuilt(int noOfHousesBuilt) {
		this.noOfHousesBuilt = noOfHousesBuilt;
	}

	//Getter method to get the price of the plot
	public int getPriceOfPlot() {
		return priceOfPlot;
	}

	//Setter method to set the price of the plot
	public void setPriceOfPlot(int priceOfPlot) {
		this.priceOfPlot = priceOfPlot;
	}


	//This method overrides the parent(Plots) class method which indicates that the current player has landed on this plot.
	@Override
	public String printToScreen() {
		return "You landed on the Avenue plot";
		
	}

}
