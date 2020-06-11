package DecoratorPhone;

public class Battery extends Attachment {
	public double batteryprice;
	public Battery(Phone phone, double price){
		this.phone = phone;
		batteryprice = price;
	}
	public double cost(){
		return phone.cost()+batteryprice;
	}
	public String getDescription(){
		return phone.getDescription()+"+ µç³Ø";
	}

}
