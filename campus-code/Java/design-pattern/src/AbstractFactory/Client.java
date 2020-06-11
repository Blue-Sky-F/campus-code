package AbstractFactory;

public class Client {
	public static void main(String args[]){
		AbstractFactory fac110 = new BMW110Factory();
		BMW bmw110 = fac110.create();
		bmw110.print();
		AbstractFactory fac007 = new BMW007Factory();
		BMW bmw007 = fac007.create();
		bmw007.print();
	}

}
