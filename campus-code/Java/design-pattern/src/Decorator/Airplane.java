package Decorator;

public class Airplane extends Changer {
	String name = "�ɻ�";
	public Airplane(Transform transform){
		super(transform);
	}
	public void move(){
		System.out.println(super.name+"��"+name+"����̬����...");
	}
	

}
