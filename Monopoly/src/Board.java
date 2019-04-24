/*This is a Singleton class which creates a Board instance. Board consists of Plots.*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

import java.util.HashMap;


public class Board {
	
	//Key attribute which uniquely defines the board.
	private static Board board;
	
	//key attribute which stores all the plot objects
	private Plots[] plots = new Plots[24];
	
	//key attribute which stores the owners of the plot which are of same color
	private HashMap<String, String[]> sameColourPlots = new HashMap<String, String[]>();
	
	//Singleton class constructor
	private Board() 
	{
		populateBoard();
		
	}
	
	//This method returns the board object
	public static Board getInstance() {
		if(board == null) 
		{
			board = new Board();
		}
		return board;
	}
	
	
	//This method initializes the plots on the board
	public void populateBoard(){
		
		getPlots()[0] = new Go(1,"GO");
		getPlots()[1] = new AvenuePlot(2,"Red",60,"REDWOOD AVE");
		getPlots()[2] = new CommunityChest(3,"COMMUNITY CHEST");
		getPlots()[3] = new AvenuePlot(4,"Red",50,"RAINBOW AVE");
		getPlots()[4] = new RailRoadPlot(5, 100, "RAILROAD");
		getPlots()[5] = new AvenuePlot(6, "Red", 40, "ROCKMONT AVE");
		getPlots()[6] = new VisitJail(7, "VISIT JAIL");
		getPlots()[7] = new ElectricityPlot(8, 100, "ELECTRICITY");
		getPlots()[8] = new AvenuePlot(9, "Blue", 60,"BLUEBERRY AVE");
		getPlots()[9] = new AvenuePlot(10, "Blue", 50, "BLACKHAWK AVE");
		getPlots()[10] = new RailRoadPlot(11, 100, "RAILROAD");
		getPlots()[11] = new Chance(12, "CHANCE");
		getPlots()[12] = new FreeParking(13, "FREE PARKING");
		getPlots()[13] = new AvenuePlot(14, "Green", 80, "GREENWOOD AVE");
		getPlots()[14] = new CommunityChest(15, "COMMUNITY CHEST");
		getPlots()[15] = new AvenuePlot(16, "Green", 90, "GOLDHILL AVE");
		getPlots()[16] = new RailRoadPlot(17, 100, "RAILROAD");
		getPlots()[17] = new AvenuePlot(18, "Green", 70, "GLACIER AVE");
		getPlots()[18] = new GoToJail(19, "GO TO JAIL");
		getPlots()[19] = new IncomeTax(20, "INCOME TAX");
		getPlots()[20] = new RailRoadPlot(21, 100, "RAILROAD");
		getPlots()[21] = new AvenuePlot(22, "Yellow", 40, "YALE AVE");
		getPlots()[22] = new AvenuePlot(23, "Yellow", 30, "YELLOW PINE AVE");
		getPlots()[23] = new Chance(24, "CHANCE");
	}
	
	
	//This method populates the same color plots on the board
	public void populateSameColourPlots() {
		
		String[] strRed = {((AvenuePlot)getPlots()[1]).getOwner(),((AvenuePlot)getPlots()[3]).getOwner(), ((AvenuePlot)getPlots()[5]).getOwner()};
		sameColourPlots.put("Red", strRed);
		
		String[] strYellow = {((AvenuePlot)getPlots()[21]).getOwner(),((AvenuePlot)getPlots()[22]).getOwner()};
		sameColourPlots.put("Yellow", strYellow);
		
		String[] strBlue = {((AvenuePlot)getPlots()[8]).getOwner(),((AvenuePlot)getPlots()[9]).getOwner()};
		sameColourPlots.put("Blue", strBlue);
		
		String[] strGreen = {((AvenuePlot)getPlots()[13]).getOwner(),((AvenuePlot)getPlots()[15]).getOwner(), ((AvenuePlot)getPlots()[17]).getOwner()};
		sameColourPlots.put("Green", strGreen);
		
	}
	
	//Getter method to get the same color plots 
	public HashMap<String, String[]> getsameColourPlots(){
		populateSameColourPlots();
		return sameColourPlots;

	}
	
	//Setter method to set the same color plots 
	public void setsameColourPlots(HashMap<String, String[]> sameColourPlots)
	{
		populateSameColourPlots();
	}

	//Getter method to get the plots 
	public Plots[] getPlots() {
		return plots;
	}

	//Setter method to set the plots 
	public void setPlots(Plots[] plots) {
		this.plots = plots;
	}
	
	//This method checks if the player owns all the plots of same color group.
	public boolean checkColourGroup(Board board, Player player) {
		
		boolean status = true;
		
		HashMap<String, String[]> plots = board.getsameColourPlots();
		
		String colour = ((AvenuePlot)board.getPlots()[player.getCurrentPlot()-1]).getColor();
		String[] owners = plots.get(colour);
		
 		
		for(int i=0; i<owners.length-1; i++) {
			if(owners[i].equals(owners[i+1])==false && owners[i]!=null) {
				status = false;
				break;
			}
		}
		
		return status;
		
	}
	
	//This method checks the owner of the current plot.
	public int checkOwner(Player player1,Player player2,int plotNumber) {
		
		String currOwner = null;
		int status=0;
		switch(plotNumber) {
		case 2:
		case 4:
		case 6:
		case 9:
		case 10:
		case 14:
		case 16:
		case 18:
		case 22:
		case 23:
			currOwner = ((AvenuePlot)plots[plotNumber-1]).getOwner();
			
			if(player2.getName().equals(currOwner) && currOwner != null) 
			{
				//This method is called when a player lands on the plot which is already owned by other player. 
				player1.performTransaction(player2, ((Avenue)player2.getCards().get(plotNumber)).getRentForPlot());
				return 2;
			}
			else if (player1.getName().equals(currOwner)&& currOwner!=null)	
			{
				return 1;
			}
			else
			{
				if(currOwner==null)
					return 0;
			}
			break;
			
			
		case 5:
		case 11:
		case 17:
		case 21:
			currOwner = ((RailRoadPlot)plots[plotNumber-1]).getOwner();
			

		if(player2.getName().equals(currOwner) && currOwner != null) 
		{
			//This method is called when a player lands on the plot which is already owned by other player. 
			player1.performTransaction(player2, ((RailRoad)player2.getCards().get(plotNumber)).getRentForRailRoad());
			return 2;
		}
		else if (player1.getName().equals(currOwner)&& currOwner!=null)	
		{
			return 1;
		}
		else
		{
			if(currOwner==null)
				return 0;
		}
			break;
			
		case 8:
			currOwner = ((ElectricityPlot)plots[plotNumber-1]).getOwner();
			
			if(player2.getName().equals(currOwner) && currOwner != null) 
			{
				
				//This method is called when a player lands on the plot which is already owned by other player. 
				player1.performTransaction(player2, ((Electricity)player2.getCards().get(plotNumber)).getRentForElectricity());
				
				return 2;
			}
			else if (player1.getName().equals(currOwner)&& currOwner!=null)	
			{
				return 1;
			}
			else
			{
				if(currOwner==null)
					return 0;
			}
			break;
			
		default:
			return 0;
	}
		return 0;
	}
}
