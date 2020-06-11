package Bulider;

public class AcerBuilder implements Builder{
	private Product acer = new Acer();

	@Override
	public void buildCPU() {
		// TODO Auto-generated method stub
		acer.add("CPU: Intel��� i3 2350M");
		
	}

	@Override
	public void buildDisplayCard() {
		// TODO Auto-generated method stub
		acer.add("�ڴ棺4GB DDR3 1333MHz");
		
	}

	@Override
	public void buildMemory() {
		// TODO Auto-generated method stub
		acer.add("�Կ���NVIDIA GeForce GT520M");
		
	}

	@Override
	public Product getFinallResult() {
		// TODO Auto-generated method stub
		return acer;
	}

}
