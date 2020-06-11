package DecoratorPhone;

public class MemoryCard extends Attachment{
	public double memoryprice;
	public MemoryCard(Phone phone, double price){
		this.phone = phone;
		this.memoryprice = price;
	}
	public String getDescription(){
		return phone.getDescription()+" +�ڴ濨";
	}
	public double cost(){
		return phone.cost()+this.memoryprice;
	}

}
