package Decorator;
/**
 * 汽车子类，扩展变形金刚的形态和功能
 * @author 徐翼飞
 *
 */
public class Car extends Transform {
	String name ="汽车";
	public void move(){
		System.out.println(super.name+"以"+name+"形态奔驰...");
	}
	

}
