package Fawry;

import java.util.ArrayList;

public class Challenge {

	public static void main(String[] args) {
		
		Product TV = new Product("TV",1000,3,false,true,5000);
		Product Cheese = new Product("Cheese",100,2,true,true,200);
		Product Biscuits = new Product("Biscuits",150,1,false,true,700);
		Product ScratchCard = new Product("CratchCard",20,10,false,false,0);
		
		Cart cart = new Cart();
		
		cart.add(Cheese, 2);
		//cart.add(TV, 3);
		//cart.add(ScratchCard,1);
		cart.add(Biscuits, 1);
		
		
		Customer fawry = new Customer("Fawry",1000);
		
		System.out.println(checkout(fawry,cart));
		


	}
	
	public static String checkout(Customer customer , Cart cart) {
		
		double total_price = 0;
		double total_weight = 0;
		ArrayList<Product> Shipped_items = new ArrayList<Product>();
		
		String weight_checkout = "** Shipment notice **";
		String price_checkout = "** Checkout receipt ** ";
		
		for(int i = 0 ; i<cart.getCart().size();i++) {
			
			Product item = cart.getCart().get(i);
			
			if(item.quantity==0) {
				System.out.println("Error: The Product is not Available");
			}else if (item.isExpired) {
				System.out.println("Error: The Product is Expired");
			}
			
			total_price = total_price + item.price*item.quantity;
			total_weight = total_weight + item.weight*item.quantity;
			
			weight_checkout = weight_checkout +'\n'+ item.quantity+"x "+item.name+"         "+item.weight*item.quantity+"g";
			price_checkout = price_checkout+'\n'+ item.quantity+"x "+item.name+"         "+(item.quantity*item.price);
			
			item.quantity = item.quantity-1;
			
			if(item.willShip) {
				Shipped_items.add(item);
			}
			
		}
		
		total_weight = total_weight/1000;
		
		weight_checkout=weight_checkout +'\n'+"Total pacakge weight "+total_weight+"kg"+'\n'+'\n';
		price_checkout = price_checkout+'\n'+"-------------------------";
		
		double shipping_price = (double)Math.round(total_price * 0.085);
		double amount = total_price + shipping_price;
		
		if(customer.Balance< amount) {
			System.out.println("Error : No Suffcient Balance");
		}
		customer.Balance = customer.Balance - amount;
		
		String Final_Receipt = weight_checkout+price_checkout+'\n'+"Subtotal          "+total_price+'\n'+"Shipping          "+
		shipping_price+'\n'+"Amount            "+amount;
		
		
		ShippingService service = new ShippingService(Shipped_items);
		return Final_Receipt;
	}
	

}
