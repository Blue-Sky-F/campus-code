package DecoratorPhone;

public class Coolpad extends Phone{
	protected double orignalprice;
	public Coolpad(double price){
		this.orignalprice = price;
		description = "ø·≈…8750 4G ÷ª˙";
	}
	public double cost(){
		return this.orignalprice;
	}

}
