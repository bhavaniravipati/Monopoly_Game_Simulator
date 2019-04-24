/*This abstract class is the parent class for the different kind of plots on the monopoly board which includes AvenuePlot, RailRoadPlot, ElectricityPlot,
Free Parking, Community Chest & Chance, Income Tax, Go cell, Go To Jail and Visit Jail. This class has methods that help us to set and get the plot number 
and plot name of these plots*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/



public abstract class Plots {
	
	//key attribute which is unique to each plot number on the monopoly board
	private int plotNumber;
	//key attribute which defines the name of the plot on the monopoly board
	private String nameOfThePlot;
	
	//Constructor
	public Plots(int plotNumber, String nameOfThePlot) 
	{
		this.plotNumber = plotNumber;
		this.nameOfThePlot = nameOfThePlot;
	}
	
	//This method is inherited by all the subclasses. 
	public abstract String printToScreen();

	//Getter method for plot number
	public int getPlotNumber() {
		return plotNumber;
	}
	
	//Setter method for plot number
	public void setPlotNumber(int plotNumber) {
		this.plotNumber = plotNumber;
	}
	
	//Getter method for plot name
	public String getNameOfThePlot() {
		return nameOfThePlot;
	}
	
	//Setter method for plot name
	public void setNameOfThePlot(String nameOfThePlot) {
		this.nameOfThePlot = nameOfThePlot;
	}
	
}
