package Decorator;
/**
 * ³éÏó×°ÊÎÀà
 * @author ĞìÒí·É
 *
 */
public abstract class Changer extends Transform {
	Transform transform;
	public Changer(Transform transform){
		this.transform = transform;
	}

}
