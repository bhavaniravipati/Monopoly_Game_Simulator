/*This class extends Plots class and has details about Go To Jail plot on the board*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class GoToJail extends Plots {

	//Constructor
	public GoToJail(int plotNumber,String nameOfThePlot) {
		super(plotNumber,nameOfThePlot);
		
	}

	//This method overrides the parent(Plots) class method which indicates that the current player who has landed on this plot has to Visit Jail.
	@Override
	public String printToScreen() {
		return "You have to go to jail.";
		
	}

}
