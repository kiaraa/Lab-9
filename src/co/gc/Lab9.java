package co.gc;

import java.util.HashMap;
import java.util.Map;

public class Lab9 {
	public static void main(String[] args) {
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
		
		System.out.printf("%-30s", "Item");
		System.out.printf("%-30s", "Price");
		System.out.println();
		System.out.println("=============================================");
		
		for(String key : inventory.keySet()) {
			System.out.printf("%-30s", key);
			System.out.printf("%-30s", "$" + inventory.get(key));
			System.out.println();
		}
		
	}
}
