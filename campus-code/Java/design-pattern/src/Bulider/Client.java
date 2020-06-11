package Bulider;

public class Client {
	public static void main(String args[]){
		Builder acerBuilder = new AcerBuilder();
		Director director1 = new Director(acerBuilder);
		director1.builder.buildCPU();
		director1.builder.buildDisplayCard();
		director1.builder.buildMemory();
		director1.builder.getFinallResult().show();
		
		System.out.println();
		
		Builder dellBuilder = new DellBuilder();
		Director director2 = new Director(dellBuilder);
		director2.builder.buildCPU();
		director2.builder.buildDisplayCard();
		director2.builder.buildMemory();
		director2.builder.getFinallResult().show();
	}

}
