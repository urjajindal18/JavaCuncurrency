package concAssignment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class UnboundedThreadedFactorization { 
	/**
	 * 
	 * @param userInput- this the number user enters to factorize
	 * @return - this returns the size of synchronized list of prime numbers, which gives the number of primes in the provided range
	 * @throws InterruptedException - As we are using CountDownLatch here, we have to do exceptionHandleing as well
	 * 
	 * Here we start a loop from 2 to user input and each number is added to a new thread to factorize
	 * we have synchronized the required data structures before executing runnable for proper results and to avoid false results.
	 * last we wait for all the threads to be finished with the help of latch and return number of primes
	 */
	
	public static Integer[] unboundedFactorization(int userInput) throws InterruptedException  {
		
		//generating synchronized data structure
		List<Integer> primeNumbers = Collections.synchronizedList(new ArrayList<Integer>());  // ArrayList for non prime numbers
		Map<Integer,Integer[]> factorsMap = Collections.synchronizedMap (new HashMap<Integer,Integer[]>()) ;
	
		
		CountDownLatch latch= new CountDownLatch(userInput-1);
		
		for (int num=2;num<=userInput;num++) 
		{
			FactorRunnable r = new FactorRunnable(latch,num,primeNumbers,factorsMap);
			Thread t=new Thread(r);
			t.start();	
			
		
		}
		latch.await();
		
		//System.out.println("Prime Numbers"+primeNumbers);
		Integer[] sizes= new Integer[2];
		sizes[0]=primeNumbers.size();
		sizes[1]=factorsMap.size();
		return sizes;
		
	
		
	}}



