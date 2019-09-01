package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); //takes in input from the user
		
		int numberOfStoreItems = scan.nextInt(); //stores the number of unique items at the store 
		String[] itemNames = new String[numberOfStoreItems]; //This string array stores the names of each unique store item
		double[] prices = new double[numberOfStoreItems]; //This double array stores the prices of each unique store item, aligned respectively with the names
		
		for (int i=0; i<numberOfStoreItems; i++) //Here we loop through each unique store item, obtaining input of the name of the item and its price
		{
			String nameOfItem = scan.next();
			double priceOfItem = scan.nextDouble();	
			itemNames[i] = nameOfItem; //we then store the input of the item name in our itemNames array
			prices[i] = priceOfItem; //we then store the input of the prices in our prices array
			
		}
		int numberOfCustomers = scan.nextInt(); //receives input on the number of customers who shopped at the store
		double[] customerTotals = new double[numberOfCustomers]; //this double array stores the total amount spent by each customer
		String[] customerNames = new String[numberOfCustomers]; //this string array stores the first and last names of the customers
		for (int i = 0; i < numberOfCustomers; i++) //loops through each customer
		{
			double total = 0; //initially sets that customers total to 0
			String firstName = scan.next(); //stores the first name of the customer
			String lastName = scan.next(); //stores the last name of the customer
			int numberOfPurchasedItems = scan.nextInt(); //stores the number of items purchased by the customer
			for (int k = 0; k < numberOfPurchasedItems; k++) //loops through each purchased item
			{
				int quantityOfItem = scan.nextInt(); //identifies the quantity of the item purchased
				String nameOfItem = scan.next(); //identifies the name of the item purchased
				
				for (int j = 0; j < itemNames.length; j++) //searches the items in the store
				{
					if (itemNames[j].equals(nameOfItem)) //if an item in the store has the same name as item purchased by a customer
					{
						total += (quantityOfItem * prices[j]); //we add the amount spent on x items to the total
						
					}
				}
					
			}
			
			customerNames[i] = firstName + " " + lastName; //adds the full name of the customer to the names array
			customerTotals[i] = total; //adds the total amount spent by a customer to the customerTotals array
		}
		
		double placeHolder; //place holder for price 
		String nameHolder; //place holder for name
		for (int i = 1; i < customerTotals.length; i++) //goes through customerTotals array
		{
			for (int j = i; j > 0; j--) //checks previous total
			{
				if (customerTotals[j] < customerTotals[j-1]) //if the previous total is greater than the next total then
				{
					placeHolder = customerTotals[j]; //use the place holder to save the next total
					nameHolder = customerNames[j]; //use a name holder to save the customer's name for then next total
					customerTotals[j] = customerTotals[j-1]; //swaps the next total with the previous total
					customerNames[j] = customerNames[j-1]; //swaps the next name with the previous name
					customerTotals[j-1] = placeHolder; //swaps the previous total with the one saved by the placeholder
					customerNames[j-1] = nameHolder; //swaps the previous name with the one saved by the name holder
				}
				
			}
		}
		scan.close(); //closes scanner.
		//Now that our totals array and customer names array are sorted...
		System.out.println("Biggest: " + customerNames[numberOfCustomers - 1] + " (" + String.format("%.2f", customerTotals[numberOfCustomers - 1]) + ")");//prints the biggest spender
		System.out.println("Smallest: " + customerNames[0] + " (" + String.format("%.2f", customerTotals[0]) + ")"); //prints the smallest spender
		
		double averageTotal = 0; 
		for (int i = 0; i < numberOfCustomers; i++) //adds the totals of each customer up
		{
			averageTotal += customerTotals[i];
		}
		
		System.out.println("Average: " + String.format("%.2f", averageTotal / numberOfCustomers)); //prints the average amount spent by each customer
	}
	

}
