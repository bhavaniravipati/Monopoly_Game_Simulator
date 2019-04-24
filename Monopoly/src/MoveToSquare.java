/*This class consists of the methods which are to be executed whenever a player wants to move within the board because of a chance or community chest card*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class MoveToSquare {

	public MoveToSquare() {
		
	}
	
	//This method is called when the player gets "Move To Go" card.
	public String execute(Player player) {
		int jumps = player.getCurrentPlot()-1;
		player.updateLocation(-jumps);
		return "You moved to Go";
	}
	
	//This method is called when the player gets "Go to Jail" card.
	public String execute(Player player, int jumps) {
		player.updateLocation(jumps);
		return "";
	}
	

}
