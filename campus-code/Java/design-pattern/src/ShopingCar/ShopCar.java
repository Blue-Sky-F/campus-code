package ShopingCar;

import java.util.ArrayList;

public class ShopCar {
	ArrayList<Item> myGoods = new ArrayList<Item>();
	public void addGoods(Item i){
		myGoods.add(i);
	}
	public void removeGoods(Item i){
		myGoods.remove(i);
	}
	
	public double calculateTotal(){
		double money=0;
		for(Item i:myGoods){
			money = money+i.getPrice()*i.getNumber();
		}
		return money;
	}
	public void pay(PaymentStrategy pms){
		pms.pay(this.calculateTotal());
	}
	

}
