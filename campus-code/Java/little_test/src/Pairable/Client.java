package Pairable;

public class Client {
	public static void main(String args[]){
			Pairable<OrderedPair> order = new OrderedPair("apple","orange");
			System.out.println(order);
			order.changeOrder();
			System.out.println(order);
			
			
	}

}
