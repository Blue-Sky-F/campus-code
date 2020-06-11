package Decorator;

public class Airplane extends Changer {
	String name = "飞机";
	public Airplane(Transform transform){
		super(transform);
	}
	public void move(){
		System.out.println(super.name+"以"+name+"的形态飞行...");
	}
	

}
