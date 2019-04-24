/*This class extends Plots class and has details about Go cell on the board*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class Go extends Plots {

	//Constructor
	public Go(int plotNumber,String nameOfThePlot) {
		
		super(plotNumber,nameOfThePlot);
		
	}

	//This method overrides the parent(Plots) class method which indicates that the current player has landed on this plot.
	@Override
	public String printToScreen() {
		return "You are in go cell. Collect 100$ from bank.";
		
	}
	

}
