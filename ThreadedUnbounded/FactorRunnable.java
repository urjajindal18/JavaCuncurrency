package concAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class FactorRunnable implements Runnable{

	List<Integer> primeNumbers;  // ArrayList for non prime numbers
	Map<Integer,Integer[]> factorMap;
	int num;
	CountDownLatch latch;
	
	/**
	 * 
	 * @param Latch - It is used for latch count down
	 * @param num - it is the number that needs to be factorized
	 * @param primeNumbers - synchronized list of prime numbers in the range
	 * @param factorMap - map of number to it's factors
	 */
	
	public FactorRunnable(CountDownLatch Latch, int num, List<Integer> primeNumbers, Map<Integer,Integer[]> factorMap ) {
		this.latch=Latch;
		this.num=num;
		this.primeNumbers=primeNumbers;
		this.factorMap=factorMap;
	}
	
	/**
	 * each thread here, create a list of factors
	 * use a for loop to check for factors
	 * check for prime or not based on number of factors
	 * add the number to primeNumbers list or map of non prime numbers to factors list
	 * reduced the latch count down by 1 
	 */
	
	@Override
	public void run() {
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
		}
		else
		{
			factors.add(num);
			Integer[] factorsArray=factors.toArray(new Integer[0]);
			factorMap.put(num, factorsArray); // Adding data to Map
		}
		latch.countDown();
	}
	
}
