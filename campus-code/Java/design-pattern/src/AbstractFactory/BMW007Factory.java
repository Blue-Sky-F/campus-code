package AbstractFactory;

public class BMW007Factory extends BMW implements AbstractFactory{

	@Override
	public BMW create() {
		return new BMW007();
	}
	

}
