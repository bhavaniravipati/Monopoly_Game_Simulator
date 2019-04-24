/*This class contains the action related to Dice*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/
import java.util.Random;

public class Dice {

	public Dice() {
		
	}
	
	//This method randomly generates a number between 1 and 6 when the Player clicks the ROLL DIE button
	public int throwDice()
	{
		Random rand = new Random();
		int randNumber = rand.nextInt((6-1)+1)+1;
		return randNumber;
		
	}
}
