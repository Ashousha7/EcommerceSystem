package Fawry;

import java.util.ArrayList;

public class Cart {

	ArrayList<Product> items;
	
	public Cart(ArrayList<Product> items) {
		this.items = items;
	}
	
	public Cart() {
		this.items = new ArrayList<Product>();
	}
	
	public ArrayList<Product> getCart() {
		return this.items;
	}
	
	public void add(Product item,int Quantity) {
		
		items.add(item);
	
		
	}

}
