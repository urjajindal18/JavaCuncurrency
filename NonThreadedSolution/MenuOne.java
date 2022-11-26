package assignment1;

import java.util.Scanner;

public class MenuOne {
	
	/**
	 * First menu starts here, after greeting, it takes input
	 * Input is done with Exception handling, so the code still works in invalid input in entered
	 * next, we have switch case, to make appropriate calls for the next task.
	 */
	
	public static void menuOne() {
		
		
		Scanner myObj=new Scanner(System.in);
		
		boolean flag=true;  // flag for the loop to continue
		System.out.print("Hello! Welcome to my Factorizer.");
		while (flag) {
			  printMenu();
		    String userInput=  myObj.nextLine();
		    int userIntegerInput;
		    try {
		    	userIntegerInput= Integer.parseInt(userInput);}
		    catch (NumberFormatException e){
		    	userIntegerInput=2;
		    }
		    
		    System.out.println(userIntegerInput);
		    
		    switch (userIntegerInput) {
		    case 1:
		    	MenuTwo.menuTwo(myObj);
		    	break;
		    case 0:
		    	System.out.println("Good Bye!");
		    	flag=false;
		    	break;
		    default:
		    	System.out.println("Invalid Input, Please try again!");
		    	break;
		    }
		}
	    myObj.close();
	}
  
  public static void printMenu(){
        System.out.println("Please choose which version you would like to launch:");
		    System.out.println("1) Non-threaded Solution");
		    System.out.println("0) Quit");
  }
	

}
