package DecoratorPhone;

public class Client {
	public static void main(String args[]){
		Phone phone = new Coolpad(1800);
		phone = new Battery(phone,150);
		phone = new BlueTooth(phone,200);
		phone = new MemoryCard(phone,300);
		phone = new PhoneShell(phone, 120);
		System.out.println("√Ë ˆ:"+phone.getDescription());
		System.out.println("º€∏Ò:"+phone.cost());
	}

}
