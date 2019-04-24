/*This class generates card objects of type Avenue, Electricity, RailRoad, Chance and Community Chest*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/
import java.util.Random;

public class GetCardFactory {

	public GetCardFactory() {
		
	}
	
	//key attribute which is unique to each plot number on the monopoly board
	private int plotNumber;
	
	//Getter method to get the current location of the player on the board.
	public void getCurrentPlot(Player player)
	{
		plotNumber=player.getCurrentPlot();
	}
	
	//This method randomly generates and returns Chance and Community Chest card based on the random number generated between 1 and 10 
	public CAndCCard getCAndCCard()
	{
		Random rand = new Random();
		int randNumber = rand.nextInt((10-1)+1)+1;
		
		
		switch(randNumber)
		{
		case 1:
			return new CAndCCard(1, "Move To Go",3);
		case 2:
			return new CAndCCard(2, "Bank error in your favor. Collect $125",15);
		case 3:
			return new CAndCCard(3, "You have won a CrossWord Competition. Collect $100",24);
		case 4:
			return new CAndCCard(4, "You have been elected as the Chairman of the Board. Pay each player $50",12);
		case 5:
			return new CAndCCard(5, "Building loan matures. Collect $150 from Bank",3);
		case 6:
			return new CAndCCard(6, "Go To Jail. Do not pass Go. Do not collect $100",15);
		case 7:
			return new CAndCCard(7, "You inherit $100",24);
		case 8:
			return new CAndCCard(8,"Hospital fees: Pay $50",12);
		case 9:
			return new CAndCCard(9, "Grand Opera Night: Collect $50 from every player for opening night seats",3);
		case 10:
			return new CAndCCard(10, "You are assessed for street repairs. Pay $40 per plot",24);
		default:
			return null;
		}
	}
	
	/*This method returns a card to the player based on the his current location on the board. A card is given to a player if he buys any one of Avenue,
	 Electricity or RailRoad plots . If he lands on chance or Community chest plot, then getCAndCCard method is called. */
	public Cards getCard(int plotNumber)
	{
		switch(plotNumber)
		{
		case 2:
			return new Avenue(20, 2,"REDWOOD AVE",2,10);
		case 3:
			return getCAndCCard();
		case 4:
			return new Avenue(20, 2,"RAINBOW AVE",4,10);
		case 5:
			return new  RailRoad(1,5);
		case 6:
			return new Avenue(20, 2, "ROCKMONT AVE",6,10);
		case 8:
			return new Electricity(1,8);
		case 9:
			return new Avenue(10, 2, "BLUEBERRY AVE",9,10);
		case 10:
			return new Avenue(10, 2, "BLACKHAWK AVE",10,10);
		case 11:
			return new RailRoad(1,11);
		case 12:
			return getCAndCCard();
		case 14:
			return new Avenue(10, 2, "GREENWOOD AVE",14,10);
		case 15:
			return getCAndCCard();
		case 16:
			return new Avenue(20, 2, "GOLDHILL AVE",16,10);
		case 17:
			return new RailRoad(1,17);
		case 18:
			return new Avenue(10, 2, "GLACIER AVE",18,10);
		case 21:
			return new RailRoad(2,21);
		case 22:
			return new Avenue(5, 2, "YALE AVE",22,10);
		case 23:
			return new Avenue(5, 2, "YELLOW PINE AVE",23,10);
		case 24:
			return getCAndCCard();
		default:
			return null;
			
		}
	}

}
