package Decorator;
/**
 * ����װ����
 * @author �����
 *
 */
public abstract class Changer extends Transform {
	Transform transform;
	public Changer(Transform transform){
		this.transform = transform;
	}

}
