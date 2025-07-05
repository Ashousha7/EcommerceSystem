package Fawry;

public class Product {
	
String name;
double price ;
int quantity;
boolean willShip;
boolean isExpired;
double weight;


public Product(String name , double price , int quantity,boolean willShip,boolean isExpired,double weight) {
	
	this.name = name;
	this.price = price;
	this.quantity = quantity ;
	this.willShip = willShip;
	this.isExpired = isExpired ;
	this.weight = weight;
}


public String getName() {
	return this.name;
}

public double getPrice() {
	return this.price;
}

public int getQuantity() {
	return this.quantity;
}

public boolean getShipped() {
	return this.willShip;
}

public boolean getExpired() {
	return this.isExpired;
}


}