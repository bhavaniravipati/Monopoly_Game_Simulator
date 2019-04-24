/*This class extends Plots class and has details about IncomeTax plot on the board*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class IncomeTax extends Plots {

	//Constructor
	public IncomeTax(int plotNumber, String nameOfThePlot) {
		super(plotNumber, nameOfThePlot);
		
	}

	//This method overrides the parent(Plots) class method which indicates that the current player has landed on this plot.
	@Override
	public String printToScreen() {
		return "You landed on IncomeTax plot. Please pay 50$";

	}
	

}
