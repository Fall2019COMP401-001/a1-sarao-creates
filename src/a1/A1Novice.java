package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); //This is our scanner. It takes input from the user and stores it in a variable type


		// Your code follows here.
		double total; //variable that stores the total
		

		int numberOfCustomers = scan.nextInt(); //receives input on the number of customers who shopped at the store
		String[] customerInfo = new String[numberOfCustomers]; //a string array that keeps track of all info for a customer including full name and total spent
		for (int i = 0; i < numberOfCustomers; i++) //goes through each customer
		{
			total = 0; //initially sets their total to 0
			String firstName = scan.next(); //stores the first name of the customer
			String lastName = scan.next(); //stores the last name of the customer
			int numberOfItems = scan.nextInt(); //stores the number of items purchased by the customer
			
			for (int j = 0; j < numberOfItems; j++) //goes through each item
			{
				int quantityOfItem = scan.nextInt(); //keeps track of the quantity of that item purchased
				String nameOfItem = scan.next(); //stores the name of that item
				double priceOfItem = scan.nextDouble(); //stores the price of that item
				
				total += (quantityOfItem * priceOfItem); //adds to the total purchased by the customer
				
			}
			
			String strCustomerInfo = firstName.substring(0,1) + ". " + lastName + ": " + String.format("%.2f", total);
			customerInfo[i] = strCustomerInfo; //adds first initial of customer, their last name and the amount they spent
			
		}
		scan.close(); //closes the scanner
		for (int i = 0; i < numberOfCustomers; i++) //loops through each customer and prints their info
		{
			System.out.println(customerInfo[i]);
		}
	}
}
