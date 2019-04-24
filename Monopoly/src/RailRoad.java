/*This class contains details about the RailRoad Plots*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/
public class RailRoad extends Cards{
	
	//key attribute which defines number of RailRoad plots owned by a player
	private int railRoadsOwned;
	
	//key attribute which is unique to each plot number on the monopoly board
	private int plotNumber;
	
	//key attribute which defines the rent the player has to pay to the owner of the RailRoad plot when he lands on that plot
	private int rent = 0;
	

	//Constructor
	public RailRoad(int railRoadsOwned,int plotNumber)
	{
		this.railRoadsOwned = railRoadsOwned;
		this.plotNumber=plotNumber;
	}
	
	//This method returns the amount of rent player has to pay to the owner depending up on the number of RailRoad plots owned by the owner.
	public int getRentForRailRoad() {
		
		if(railRoadsOwned >0 && railRoadsOwned<=2) {
			rent = 25;
		}
		
		else if(railRoadsOwned >2 && railRoadsOwned<=4) {
			rent= 50;
			
		}
		
		return rent;
	}

	@Override
	public String printToScreen() {
		
		return "You have received a railroad card";
	}

	
	
}
