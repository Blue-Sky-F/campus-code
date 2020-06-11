package DecoratorPhone;

public class BlueTooth extends Attachment{
	public double bluetoothprice;
	public BlueTooth(Phone phone, double price){
		this.phone = phone;
		this.bluetoothprice = price;
	}
	public String getDescription(){
		return phone.getDescription()+"+ А¶СА";
	}
	public double cost(){
		return phone.cost()+this.bluetoothprice;
	}

}
