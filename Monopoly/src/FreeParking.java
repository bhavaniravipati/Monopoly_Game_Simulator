/*This class extends Plots class and has details about Free Parking plot on the board*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class FreeParking extends Plots {

	//Constructor
	public FreeParking(int plotNumber,String nameOfThePlot) {
		super(plotNumber,nameOfThePlot);
		
	}
	
	//This method overrides the parent(Plots) class method which indicates that the current player has landed on this plot.
	@Override
	public String printToScreen() {
		return "You are using Free Parking service.";
		
	}
	

}
