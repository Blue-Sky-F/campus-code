package AbstractFactory;

public class BMW110Factory extends BMW implements AbstractFactory{

	@Override
	public BMW110 create() {
		return new BMW110();
	}
	

}
