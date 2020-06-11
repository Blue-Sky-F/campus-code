package ShopingCar;

public class Item {
	String name;
	double price;
	int number;
	Item(String name, double price ,int number){
		this.name = name;
		this.price = price;
		this.number = number;
	}
	Item(String name, double price){
		this.name = name;
		this.price = price;
	}
	public void setName(String n){
		
	}
	public void setPrice(double p){
		
	}
	public void setNumber(int u){
		
	}
	public String getName(){
		return this.name;
	}
	public double getPrice(){
		return this.price;
	}
	public int getNumber(){
		return this.number;
	}

}
