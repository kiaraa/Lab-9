package co.gc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = false;
		
		ArrayList<String> shoppingCart = new ArrayList<>();
		Map<String, Double> inventory = new HashMap<>();
		inventory.put("Roses", 21.99);
		inventory.put("Daisies", 15.99);
		inventory.put("Bridal Bouquet", 120.99);
		inventory.put("Mother's Day Bouquet", 31.99);
		inventory.put("Lillies", 18.99);
		inventory.put("Small Mixed Bouquet", 12.99);
		inventory.put("Medium Mixed Bouquet", 19.99);
		inventory.put("Large Mixed Bouquet", 24.99);
		
		System.out.println("Welcome to the flower shop!");
		System.out.println();
		
		do {
			displayTable(inventory);
			System.out.println();
			addItemToCart(shoppingCart, inventory, scan);
			keepGoing = getContinue(scan);
		} while (keepGoing);
		
		showOrder(inventory, shoppingCart);
		
		scan.close();
	}
	
	public static void displayTable(Map<String, Double> inventory) {
		System.out.printf("%-30s", "Item");
		System.out.printf("%-30s", "Price");
		System.out.println();
		System.out.println("=============================================");
		
		for(String key : inventory.keySet()) {
			System.out.printf("%-30s", key);
			System.out.print("$" + inventory.get(key));
			System.out.println();
		}	
	}
	
	public static void addItemToCart(ArrayList<String> shoppingCart, Map<String, Double> inventory, Scanner scan) {
		System.out.println("What would you like to order? ");
		String purchase = scan.nextLine();
		if (inventory.containsKey(purchase)) {
			shoppingCart.add(purchase);
			System.out.println("Adding " + purchase + "to cart at $" + inventory.get(purchase) + ".");
		}
		else {
			System.out.println("Sorry, we don't sell that. Please order from our inventory.");
			displayTable(inventory);
			addItemToCart(shoppingCart, inventory, scan);
		}
	}
	
	public static boolean getContinue (Scanner scan) {
		System.out.println("Would you like to order anything else? (y/n) ");
		String input = scan.nextLine();
		
		if (input.equalsIgnoreCase("y")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void showOrder(Map<String, Double> inventory, ArrayList<String> shoppingCart) {
		System.out.println("Thank you for shopping with us! Here is your receipt:");
		
		for (String key : shoppingCart) {
			System.out.printf("%-25s", key);
			System.out.print("$" + inventory.get(key));
			System.out.println();
		}
		double subtotal = getSubtotal(shoppingCart, inventory);
		double tax = getTax(subtotal);
		double total = subtotal + tax;
		System.out.println("========");
		System.out.println();
		System.out.println("Order Subtotal: " + "$" + subtotal);
		System.out.printf("%17s", "+ tax $");
		System.out.print(String.format("%.2f", tax));
		System.out.println();
		System.out.println("========");
		System.out.printf("%17s", "Total: $");
		System.out.printf("%.2f", total);
		System.out.println();
		System.out.println("Average item price (tax not included): " + getAverage(shoppingCart, subtotal));
	}
	
	public static double getSubtotal(ArrayList<String> shoppingCart, Map<String, Double> inventory) {
		double subtotal = 0;
		for (String key : shoppingCart) {
			subtotal += inventory.get(key);
		}
		return subtotal;
	}
	
	public static double getTax(double subtotal) {
		return subtotal * 0.06;
	}
	
	public static double getAverage(ArrayList<String> shoppingCart, double subtotal) {
		return (subtotal / shoppingCart.size());
	}
}
