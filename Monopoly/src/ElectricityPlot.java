/*This class extends Plots class and has details about Electricity plot on the board*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class ElectricityPlot extends Plots {

	//Key attribute which holds the name of player who owns the plot
	private String owner=null;
	
	//Key attribute which defines the price of the plot which the player has to pay to the bank to but it
	private int priceOfElectricityPlot;
	
	
	//Constructor
	public ElectricityPlot(int plotNumber, int priceOfElectricityPlot, String nameOfThePlot) {
		super(plotNumber,nameOfThePlot);
		this.priceOfElectricityPlot=priceOfElectricityPlot;
		
	}

	//Getter method to get the owner of the Electricity plot
	public String getOwner() {
		return owner;
	}

	//Setter method to set the owner of the Electricity plot
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	//Getter method to get the price of the Electricity plot
	public int getPriceOfElectricityPlot() {
		return priceOfElectricityPlot;
	}

	//Setter method to set the price of the Electricity plot
	public void setPriceOfElectricityPlot(int priceOfElectricityPlot) {
		this.priceOfElectricityPlot = priceOfElectricityPlot;
	}

	
	//This method overrides the parent(Plots) class method which indicates that the current player has landed on this plot.
	@Override
	public String printToScreen() {
		return "You are using electricity service.";
		
	}

}
