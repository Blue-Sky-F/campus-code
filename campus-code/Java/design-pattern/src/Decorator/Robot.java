package Decorator;
/**
 * 具体装饰类，为变形金刚动态地扩展状态和行为
 * @author 徐翼飞
 *
 */
public class Robot extends Changer {
	String name = "机器人";
	public Robot(Transform transform){
		super(transform);
	}
	public void move(){
		System.out.println(super.name+"以"+name+"的形态奔驰...");
	}
	public void say(){
		System.out.println(super.name+"以"+name+"的形态在说话...");
	}
	

	

}
