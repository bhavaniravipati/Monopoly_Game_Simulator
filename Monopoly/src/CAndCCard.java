/*This class contains details about the Chance and Community Chest Plots. We have defined 10 chance and Community chest cards*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/
public class CAndCCard extends Cards{

	//key attribute which is unique to each Card
	private int cardNumber;
	
	//Key attribute which contains the action that the player has to perform when he gets a particular card
	private String description;
	
	//key attribute which is unique to each plot number on the monopoly board
	private int plotNumber;
	

	//Constructor
	public CAndCCard(int cardNumber,String description,int plotNumber) {
		this.cardNumber=cardNumber;
		this.description=description;
		this.plotNumber=plotNumber;
	}


	//Getter method to get the description of the card
	public String getDescription() {
		return description;
	}


	//Setter method to set the description of the card
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String printToScreen() {
		return this.description;
	}
	
	
	
	
}
