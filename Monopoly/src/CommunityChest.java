/*This class extends Plots class and has details about Community Chest plot on the board*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class CommunityChest extends Plots {

	//Constructor
	public CommunityChest(int plotNumber,String nameOfThePlot) {
		super(plotNumber,nameOfThePlot);
		
	}

	//This method overrides the parent(Plots) class method which indicates that the current player has landed on this plot.
	@Override
	public String printToScreen() {
		return "You landed in Community Chest Plot. You will be given a card, follow the instructions on it.";
		
	}

}
