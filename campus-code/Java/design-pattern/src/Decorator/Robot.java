package Decorator;
/**
 * ����װ���࣬Ϊ���ν�ն�̬����չ״̬����Ϊ
 * @author �����
 *
 */
public class Robot extends Changer {
	String name = "������";
	public Robot(Transform transform){
		super(transform);
	}
	public void move(){
		System.out.println(super.name+"��"+name+"����̬����...");
	}
	public void say(){
		System.out.println(super.name+"��"+name+"����̬��˵��...");
	}
	

	

}
