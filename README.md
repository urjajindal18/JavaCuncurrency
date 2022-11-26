# JavaCuncurrency

Here we are dealing with one question and we will look up for solving the same problem in different ways.
We will start with a non threaded solution first and will apply the concepts of concurrency and threads to the same problem with different parameters.

PROBLEM

Greet the user with a menu.  
For now, the menu will have an introduction and a single option. It should look like the following:

```
Hello! Welcome to my Factorizer.  Please choose which version you would like to launch:

1) Non-Threaded Solution

0) Quit
```
When the user hits 0 and presses enter, the program should terminate.

When the user hits 1 and presses enter, you should be greeted with a new menu that says:

`Please enter the number you'd like to factorize:`

The program should then take a numerical integer input.  You do not need to use BigInteger or long for this, a regular integer is fine.  
This is more about design than about function.

Now that you have this number, you want to compute all the prime numbers that exist between 2 and that number (inclusive).

If a number is not prime, you will store that number and an array of its factors in a Map<Integer, Integer[]>


If a number is prime you will store it in a List<Integer>.  
So, at the conclusion, we have a Map of non primes that contain factors of numbers and a list of primes.

You will time the runtime of your application so that we know how long it will take to build these two structures. 
To time your application, simply generate a starting time as soon as you retrieve the number you want to use as the base of your iteration and then stop the timer when you are finished generating your structures.  Report back what the difference is. You can use System.currentTimeMillis(); to do this.

The program should then report back to the user the number of primes in the List, and the number of items in the Map.  
You do not need to print these structures, but you should be able to access them in the proper context in the code.


You can then return to the menu so the user can input another number, or enter a number to return to the first menu.
