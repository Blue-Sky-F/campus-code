package DecoratorPhone;

public class Coolpad extends Phone{
	protected double orignalprice;
	public Coolpad(double price){
		this.orignalprice = price;
		description = "����8750 4G�ֻ�";
	}
	public double cost(){
		return this.orignalprice;
	}

}
