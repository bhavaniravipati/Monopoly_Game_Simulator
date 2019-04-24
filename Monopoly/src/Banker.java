/*This is a Singleton class which creates a Banker instance.*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class Banker {

	//Key attribute which uniquely defines the banker.
	private static Banker banker=null;
	
	//Key attribute which holds the balance of the banker which is initialized to $5000.
	private int balance = 5000;
	
	private Banker() {
		
	}
	
	//This method returns the banker object
	public static Banker getInstance() {
		if(banker == null) 
			banker = new Banker();
		return banker;
	}

	//Getter method to get the balance of the banker
	public int getBalance() {
		return balance;
	}

	//Setter method to set the balance of the banker
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
