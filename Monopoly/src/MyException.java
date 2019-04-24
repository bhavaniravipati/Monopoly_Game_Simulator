/*This class is defined to throw user defined exceptions*/

/*Authors: Priyanka Sundaram, Bhavani Rishitha Ravipati, Reshma Chowdary Morampudi*/

public class MyException extends Exception{
	
	private static final long serialVersionUID = 1L;
	String str1;

	//Constructor
	MyException(String str2){
		str1 = str2;
	}
	
	//This method returns the user defined exception
	public String toString() {
		return "Expection Occured: "+str1;
	}
}
