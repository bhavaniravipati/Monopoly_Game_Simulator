/*This class acts as a controller in the MVC architecture which connects the view and the business logic. This class receives requests from the UI and directs 
 these requests to the appropriate logic of the code and send the responses to the UI*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/MonopolyController")
public class MonopolyController extends HttpServlet
{	
	//key attribute which uniquely defines the current number of turns in the game.
	int numberOfTurns;
	
	//Key attributes which keeps track of players
	Player player1, player2;
	
	//Key attribute which keeps track of Banker object.
	Banker banker;
	
	//Key attribute which defines the board instance
	Board board;
	
	//Key attribute which defines the dice object
	Dice dice;
	
	//Key attribute which is used to access method of the Game Controller class.
	GameController gc;
	
	//Key attribute which holds the action of the player 
	Action action ;
	
	//Key attribute which is used to perform transactions between players and Banker
	MoneyTransaction transact;
	
	//Key attribute which is used to get the cards from the GetCardFactory class.
	GetCardFactory getCard;
	
	//Key attribute which is used to connect to the Game Simulator class
	GameSimulator gs;
	
	RequestDispatcher dispatcher=null;
	
	//This method is called only once when server starts for the first time.
	public void init() throws ServletException
	{
		//Number of turns is initialized only once in the game.
		numberOfTurns=0;
		
		player1 = new Player();
		player2 = new Player();
		
		banker = Banker.getInstance();
		
		board = Board.getInstance();
		
		dice = new Dice();
		
		gc = new GameController();
		
		action = new Action();
		
		transact = new MoneyTransaction();
		
		getCard = new GetCardFactory();
		
		gs = new GameSimulator();
	}
	

	//This method sets attributes based on the player's action.
	public void setAttributes(int diceNumber, String player1Name, String player2Name, int player1Location, int player2Location, int player1Balance,
			int player2Balance, int bankBalance, int numberOfTurns, int enableBuy, int enableBuild, HttpServletRequest request, HttpServletResponse response,
			String description)
	{
		request.setAttribute("dice",diceNumber);
		request.setAttribute("player1Name",player1Name);
		request.setAttribute("player2Name", player2Name);
		request.setAttribute("player1Location", player1Location);
		request.setAttribute("player2Location", player2Location);
		request.setAttribute("player1Balance", player1Balance);
		request.setAttribute("player2Balance",player2Balance);
		request.setAttribute("bankBalance",bankBalance );
		request.setAttribute("totalRounds", numberOfTurns);
		request.setAttribute("enableBuy", enableBuy);
		request.setAttribute("enableBuild", enableBuild);
		request.setAttribute("description", description);
	}
	
	//This method redirects to monopoly.jsp page if the game is still going on and redirects to winner's page if the game is done.
	public void renderPage(GameController gc, GameSimulator gs, HttpServletRequest request, HttpServletResponse response, Player player1, Player player2) throws ServletException, IOException
	{
		if(gc.stop(player1, player2, numberOfTurns))
		{
			String winner=gs.stop(player1, player2, gc);
			request.setAttribute("winner", winner);
			

			dispatcher=request.getRequestDispatcher("/winner.jsp");
			dispatcher.forward(request,response);
		}
		else
		{
			dispatcher=request.getRequestDispatcher("/monopoly.jsp");
			dispatcher.forward(request,response);
		}
	}
	
	/*This method is called when a player interacts with the UI. this method is used to get parameters passed by the player 
	and performs actions according to the player's requests and send response to the UI. */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException
    {
		
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList = gs.first(numberOfTurns, player1, player2, gc);
				
		String player1Name = request.getParameter("player1");
		String player2Name = request.getParameter("player2");
		
		String buildHouseButton = request.getParameter("Build");
		String buyPlotButton = request.getParameter("Buy");
		String diceButton = request.getParameter("Dice");
		String endButton=request.getParameter("End");
		int enableBuy=0;
		int enableBuild=0;
		Integer diceNumber;
		String description="";
		
		
		
		//Login Page
		if(player1Name != null && player2Name!=null && buildHouseButton == null && buyPlotButton==null && diceButton==null) {
			
			playerList.get(0).setName(player1Name);
			playerList.get(1).setName(player2Name);
			
			setAttributes(0, player1Name, player2Name,1,1,
					playerList.get(0).getBalance(),playerList.get(1).getBalance(),banker.getBalance(), numberOfTurns,0,0,request,response,"");
			
			
			dispatcher = request.getRequestDispatcher("/monopoly.jsp");
			dispatcher.forward(request, response);
		}
		
		
		//Enters this if player click on ROLL DIE button on UI
		if(diceButton != null) {
			
			
			gs.second(playerList.get(0), playerList.get(1), dice, banker, board, transact, gc);
			
			int location=playerList.get(0).getCurrentPlot();
			
			//Enters this loop is player lands on Avenue plots
			if(location==2 || location==4 || location==6 || location==9 || location==10 || location==14 || location==16 || location==18 || location==22 || location==23)
			{
				//checks if the current player is owner of the plot
				int owner=board.checkOwner(playerList.get(0), playerList.get(1), location);
				
				//If current player is owner of the plot, player can build house on that plot
				if(owner==1)
				{	
					enableBuild=1;
				}
				//If second player is owner of the plot, current player has to pay rent to player2
				else if(owner==2)
				{
					enableBuy=0;
					enableBuild=0;
				}
				//If no owner for the plot, current player can buy that plot
				else if(owner==0)
				{
					
					enableBuy=1;
					enableBuild=0;
				}
			}
			//Enters this if current player lands on the RailRoad plot
			else if(location==5 ||location==11||location==17||location==21)
			{
				//If the plot is not owned by anyone, current player can buy that plot
				if(board.checkOwner(playerList.get(0), playerList.get(1), location)==0)
				{
					enableBuy=1;
				}
				else
					enableBuy=0;
				
			}
			//Enters this if current player lands on the Electricity plot
			else if (location==8)
			{
				//If the plot is not owned by anyone, current player can buy that plot
				if(board.checkOwner(playerList.get(0), playerList.get(1), location)==0)
				{
					enableBuy=1;
				}
				else
				{
				enableBuy=0;
				}
			}
			//Enters this if current player lands on Chance, Community Chest, Income Tax or Go To jail plots 
			else if (location==3 ||location==12||location==15||location==20||location==24|| location==19)
			{
				description=gs.run("", location, playerList.get(0), playerList.get(1), banker, board, dice, gc, action, transact, getCard);
				
				
			}
			
			diceNumber = gs.diceNumber;			
			
			setAttributes(diceNumber, playerList.get(0).getName(), playerList.get(1).getName(),playerList.get(0).getCurrentPlot(),playerList.get(1).getCurrentPlot(),
					playerList.get(0).getBalance(),playerList.get(1).getBalance(),banker.getBalance(), numberOfTurns,enableBuy,enableBuild,request,response,description);

			
			renderPage(gc,gs,request,response,playerList.get(0),playerList.get(1));
			
		}
		//Enters this if player click on Buy plot button on the UI
		if(buyPlotButton != null) {
			
			description=gs.run("Buy", numberOfTurns, playerList.get(0), playerList.get(1), banker, board, dice, gc, action, transact, getCard);
			
			diceNumber=gs.diceNumber;
			
			
			setAttributes(diceNumber, playerList.get(0).getName(), playerList.get(1).getName(),playerList.get(0).getCurrentPlot(),playerList.get(1).getCurrentPlot(),
					playerList.get(0).getBalance(),playerList.get(1).getBalance(),banker.getBalance(), numberOfTurns,enableBuy,enableBuild,request,response,description);
			

			
			renderPage(gc,gs,request,response,playerList.get(0),playerList.get(1));
		}
		
		//Enters this if player clicks on Build House button on the UI
		if(buildHouseButton != null) {
			
			description=gs.run("Build", numberOfTurns, playerList.get(0), playerList.get(1), banker, board, dice, gc, action, transact, getCard);
			
			
			diceNumber=gs.diceNumber;
			
			
			setAttributes(diceNumber, playerList.get(0).getName(), playerList.get(1).getName(),playerList.get(0).getCurrentPlot(),playerList.get(1).getCurrentPlot(),
					playerList.get(0).getBalance(),playerList.get(1).getBalance(),banker.getBalance(), numberOfTurns,enableBuy,enableBuild,request,response,description);
			

			renderPage(gc,gs,request,response,playerList.get(0),playerList.get(1));
			
			

		}
		//Enters this if player clicks on End Turn button on the UI
		if(endButton!=null)
		{
			numberOfTurns+=1;
			diceNumber=gs.diceNumber;
			
			
			setAttributes(diceNumber, playerList.get(0).getName(), playerList.get(1).getName(),playerList.get(0).getCurrentPlot(),playerList.get(1).getCurrentPlot(),
					playerList.get(0).getBalance(),playerList.get(1).getBalance(),banker.getBalance(), numberOfTurns-1,enableBuy,enableBuild,request,response,"");
			
			
			renderPage(gc,gs,request,response,playerList.get(0),playerList.get(1));

		}
		
	
    }
	
}


