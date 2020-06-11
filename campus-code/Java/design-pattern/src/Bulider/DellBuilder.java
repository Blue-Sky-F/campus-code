package Bulider;

public class DellBuilder implements Builder{
	private Product dell = new Dell();

	@Override
	public void buildCPU() {
		// TODO Auto-generated method stub
		dell.add("CPU: Intel ��� i7 3612QM");
		
	}

	@Override
	public void buildDisplayCard() {
		// TODO Auto-generated method stub
		dell.add("�ڴ棺NVIDIA GeForce GT 640M + IntelGMA HD 4000");
		
	}

	@Override
	public void buildMemory() {
		// TODO Auto-generated method stub
		dell.add("�Կ�:8GB DDR3 1600MHz");
		
	}

	@Override
	public Product getFinallResult() {
		// TODO Auto-generated method stub
		return dell;
	}
	

}
