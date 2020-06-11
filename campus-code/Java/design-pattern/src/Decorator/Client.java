package Decorator;

public class Client {
	public static void main(String args[]){
		Transform trans1 = new Car();
		trans1.move();
		Transform trans = new Car();
		Robot robot = new Robot(trans);
		robot.move();
		robot.say();
		Airplane air = new Airplane(trans);
		air.move();
		
	}

}
