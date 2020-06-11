package DecoratorPhone;

public abstract class Phone {
	String description;
	public  String getDescription(){
		return this.description;
	}
	public abstract double cost();
}
