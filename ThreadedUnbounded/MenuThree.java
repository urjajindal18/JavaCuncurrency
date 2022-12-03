package concAssignment;

import java.util.Scanner;



public class MenuThree {
	
	/**
	 * We declare timers globally as they are used in two different methods
	 * userInput, variable is also declared globally, which is the value entered by user for factorization
	 */
	
	static long startTime, stopTime;
	static int userInput;
	static Integer[] sizeCounts;
	
	/**
	 * after taking the user input , code checks for valid input
	 *if input is -1, code is returned back to menu 1
	 *else, we start the timer to get execution time and call the UnboundedThreadedFactorization class 
	 * and get count of prime numbers
	 * then we stop the timer and call the output method.
	 * After output it printed, the loop runs again and ask for user Input
	 * 
	 * @throws exception -  CountDowanLatch for threads is being used in unboundedThreadedFactorization class and we are calling that class here.
	 */
	
	
	public static void menuThree(Scanner obj) throws InterruptedException {
		boolean flag2=true;  // flag for loop to continue
		
		while (flag2) {
			
			System.out.println("Please enter the number you'd like to factorize using unbounded threads, -1 to return to the previous menu:");
			String uInput=  obj.nextLine();  // User input for menu 2
		    try {
		    	userInput= Integer.parseInt(uInput);}
		    catch (NumberFormatException e){
		    	System.out.println("Invalid Input");
		    	userInput=0;
		    	continue;
		    }
			
			if (userInput==-1)     // Returning back to main menu
				flag2=false;
			
			else if (userInput<2)
			{
				System.out.println("Invalid Input, please enter a number greater than equal to 2.");
				continue;
			}
			else
			{
				startTime=System.currentTimeMillis(); 
				//PrimeNumberInRange.primeCount(userInput);
				System.out.println("Counting Primes...");
				sizeCounts=UnboundedThreadedFactorization.unboundedFactorization(userInput);
				stopTime=System.currentTimeMillis();
				output(sizeCounts);
			}
		}
		return;
	}
	/**
	 @param primeCount - this is the number of prime number between 2 and the user input
	 * 
	 * This part of code,
	 * gives all the required outputs for prime count, non prime count and execution time.
	 */
	
	public static void output(Integer[] sizeCounts) 
	{
		System.out.println("The number of primes between 2 and "+userInput +" is " + sizeCounts[0] +".");
		System.out.println("The number of non primes between 2 and "+userInput +" is " + sizeCounts[1] +".");
		System.out.println("This calculation took "+ (stopTime-startTime) +"ms");
		
		
	}

}
