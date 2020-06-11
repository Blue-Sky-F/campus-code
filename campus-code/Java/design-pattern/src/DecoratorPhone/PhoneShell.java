package DecoratorPhone;

public class PhoneShell extends Attachment{
	public double phoneshellprice;
	public PhoneShell(Phone phone, double price){
		this.phone = phone;
		this.phoneshellprice = price;
	}
	public String getDescription(){
		return phone.getDescription()+" +ÍâÌ×";
	}
	public double cost(){
		return phone.cost()+this.phoneshellprice;
	}

}
