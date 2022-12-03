package concAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factorization {
	/**
	 * 
	 * @param userInput is the number provided by user for factorization.
	 * @return primeCount, here we are returning the number of prime numbers between 2 and the userInput
	 * Here, we check for factors of all the numbers between 2 and the user input 
	 * if there is only one factor in the factors list(which is '1'), that means the number is a prime number
	 * So, we add it to the list primeNumbers
	 * else, we are adding the number itself to the list and adding it to the map
	 */
	public static int factorizing(int userInput) {
		
		List<Integer> primeNumbers = new ArrayList<Integer>();  // ArrayList for non prime numbers
		int primeCount=0;
		Map<Integer,Integer[]> factorMap = new HashMap<Integer,Integer[]>();
		
		for (int num=2;num<=userInput;num++) 
		{
			List<Integer> factors = new ArrayList<Integer>(); //ArrayList for Factors
			for(int i=1;i<=num/2;i++) 
			{
				if (num%i==0)
					factors.add(i);	
			}
			int length=factors.size();
			if (length==1) // it is prime number
			{
				primeNumbers.add(num);
				primeCount++;
			}
			else
			{
				factors.add(num);
				Integer[] factorsArray=factors.toArray(new Integer[0]);
				factorMap.put(num, factorsArray); // Adding data to Map
			}	
			
		}
		return primeCount;
		
	}


}
