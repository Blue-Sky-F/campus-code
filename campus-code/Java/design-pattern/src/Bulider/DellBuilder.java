package Bulider;

public class DellBuilder implements Builder{
	private Product dell = new Dell();

	@Override
	public void buildCPU() {
		// TODO Auto-generated method stub
		dell.add("CPU: Intel ¿áî£ i7 3612QM");
		
	}

	@Override
	public void buildDisplayCard() {
		// TODO Auto-generated method stub
		dell.add("ÄÚ´æ£ºNVIDIA GeForce GT 640M + IntelGMA HD 4000");
		
	}

	@Override
	public void buildMemory() {
		// TODO Auto-generated method stub
		dell.add("ÏÔ¿¨:8GB DDR3 1600MHz");
		
	}

	@Override
	public Product getFinallResult() {
		// TODO Auto-generated method stub
		return dell;
	}
	

}
