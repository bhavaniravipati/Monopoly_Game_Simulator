/*This abstract class is the parent class for the chance and community chest cards*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public abstract class Cards{
	
	//Key attribute which defines the number of the plot on the board.
	private int plotNumber;
	
	
	public abstract String printToScreen();

	//Getter method to get the plot number
	public int getPlotNumber() {
		return plotNumber;
	}

	//Setter method to set the plot number
	public void setPlotNumber(int plotNumber) {
		this.plotNumber = plotNumber;
	}

}
