/*This class extends Plots class and has details about Visit Jail plot on the board*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class VisitJail extends Plots {

	//Constructor
	public VisitJail(int plotNumber, String nameOfThePlot) {
		super(plotNumber,nameOfThePlot);
		
	}

	//This method overrides the parent(Plots) class method which indicates that the current player has landed on this plot.
	@Override
	public String printToScreen() {
			return "You are visiting the jail.";
	}

}
