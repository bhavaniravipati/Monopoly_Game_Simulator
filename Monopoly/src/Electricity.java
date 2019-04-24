/*This class contains details about the Electricity Plot*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/
public class Electricity extends Cards{

	//key attribute which defines number of Electricity plots owned by a player
	private int electricityOwned;

	//key attribute which is unique to each plot number on the monopoly board
	private int plotNumber;
	
	//key attribute which defines the rent the player has to pay to the owner of the Electricity plot when he lands on that plot
	private int rent = 0;
	
	//Constructor
	public Electricity(int electricityOwned,int plotNumber) {
		this.electricityOwned=electricityOwned;
		this.plotNumber=plotNumber;
		
	}
	
	//This method returns the amount of rent player has to pay to the owner depending up on the number of Electricity plots owned by the owner.
	public int getRentForElectricity()
	{
		if(electricityOwned>0)
			rent=25;
		
		return rent;
	}

	@Override
	public String printToScreen() {
		
		return "You have received Electricity card";
	}
	
	
}
