/*This class contains details about the Avenue Plots*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class Avenue extends Cards{

	//key attribute which is unique to each plot number on the monopoly board
	private int plotNumber;
	
	//key attribute which defines the rent the player has to pay to the owner of the plot when he lands on that plot
	private int rentForPlot;
	
	//key attribute that defines the maximum number of houses that the owner of that plot can build on it.
	private int maxHousesCanBeBuilt;
	
	//key attribute which holds the name of the Avenue plot
	private String nameOfTheAvenue;
	
	//Key attribute which defines the amount the player has to pay to the bank to build a house on the plot he owns
	private int costToBuildHouse;
	
	
	//Constructor
	public Avenue(int rentForPlot, int maxHousesCanBeBuilt, String nameOfTheAvenue,int plotNumber,int costToBuildHouse) {
		this.setRentForPlot(rentForPlot);
		this.setMaxHousesCanBeBuilt(maxHousesCanBeBuilt);
		this.setNameOfTheAvenue(nameOfTheAvenue);
		this.setPlotNumber(plotNumber);
		this.setCostToBuildHouse(costToBuildHouse);
	}


	//Getter method to get the rent of the plot
	public int getRentForPlot() {
		return rentForPlot;
	}

	//Setter method to set the rent of the plot
	public void setRentForPlot(int rentForPlot) {
		this.rentForPlot = rentForPlot;
	}

	//Getter method to get the maximum houses that can be built on the plot
	public int getMaxHousesCanBeBuilt() {
		return maxHousesCanBeBuilt;
	}

	//Setter method to set the maximum houses that can be built on the plot
	public void setMaxHousesCanBeBuilt(int maxHousesCanBeBuilt) {
		this.maxHousesCanBeBuilt = maxHousesCanBeBuilt;
	}

	//Getter method to get name of the avenue
	public String getNameOfTheAvenue() {
		return nameOfTheAvenue;
	}

	//Setter method to set the name of the Avenue
	public void setNameOfTheAvenue(String nameOfTheAvenue) {
		this.nameOfTheAvenue = nameOfTheAvenue;
	}

	
	
	//Getter method to get plot number
	public int getPlotNumber() {
		return plotNumber;
	}
	//Setter method to set plot number
	public void setPlotNumber(int plotNumber) {
		this.plotNumber = plotNumber;
	}

	//Getter method to get cost to build a house
	public int getCostToBuildHouse() {
		return costToBuildHouse;
	}
	//Setter method to set cost to build a house
	public void setCostToBuildHouse(int costToBuildHouse) {
		this.costToBuildHouse = costToBuildHouse;
	}


	@Override
	public String printToScreen() {
		
		return "You have received "+this.nameOfTheAvenue+" card";
	}
	
}
