package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); //This is our scanner. It takes input from the user and stores it in a variable type

		// Your code follows here.
		int numberOfStoreItems = scan.nextInt(); //Enters the number of unique items at the store
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
		int[] totalOfItemPurchased = new int[numberOfStoreItems]; //this array keeps track of the quantity of purchased items for each unique item
		int[] customersPerItem = new int[numberOfStoreItems]; //this array keeps track of how many customers purchase a particular item
		boolean[] customerAlreadyAdded = new boolean[numberOfStoreItems]; //this boolean ensures no one customer is added twice for an item
		
		for (int i = 0; i < totalOfItemPurchased.length; i++) //initializes each index in in totalOfItemPurchased and customersPerItem to 0
		{
			totalOfItemPurchased[i] = 0;
			customersPerItem[i] = 0;
			
		}
		
		for (int i = 0; i < numberOfCustomers; i++) //Now we go through each customer who shopped at the store
		{
			//double total = 0;
			String firstName = scan.next(); //receives input on their first name
			String lastName = scan.next(); //receives input on their last name
			
			for (int l = 0; l < numberOfStoreItems; l++) //we initialize the boolean array to 0 as each new customer will start with 0 already purchased items
			{
				customerAlreadyAdded[l] = false;
			}
			
			int numberOfPurchasedItems = scan.nextInt(); //now we go through the number of items a customer purchased
			
			for (int k = 0; k < numberOfPurchasedItems; k++) //loops through each item inputed as purchased
			{
				int quantityOfItem = scan.nextInt(); //stores the quantity of the item purchased
				String nameOfItem = scan.next(); //stores the name of the item purchased
				
				for (int j = 0; j < itemNames.length; j++) //now we search through each item we have in the store
				{
					if (itemNames[j].equals(nameOfItem)) //if an item name is the same as one purchased by a customer then
					{
						if (customerAlreadyAdded[j] == true) //we check to see if a customer already purchased this item. If so, we only change the quantity of that item purchased
						{
							totalOfItemPurchased[j] += quantityOfItem;
							
						}
						
						else //if the customer has not already purchased this item, we add the quantity they purchased, add 1 to the total customers who purchased this item, and set the boolean array index to true
						{
							totalOfItemPurchased[j] += quantityOfItem;
							customersPerItem[j] += 1;
							customerAlreadyAdded[j] = true;
						}

					}
					
				}
					
			}		
			
		}
		
		scan.close(); //closes scanner
		for (int i = 0; i < numberOfStoreItems; i++) //now we loop through each unique store item
		{
			if (customersPerItem[i] == 0) //if the total customers who purchased this item is 0 then we output that no customers purchased this item
			{
				System.out.println("No customers bought " + itemNames[i]);
			}
			
			else //if the total customers who purchased this item isn't zero then we output the number of customers, the quantity who purchased, and the name of the item
			{
				System.out.println(customersPerItem[i] + " customers bought " + totalOfItemPurchased[i] + " " + itemNames[i]);
			}
			
			
		}
	}
}
