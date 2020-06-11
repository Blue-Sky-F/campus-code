package Pairable;
/**
 * An interface defines methods of tow objects having the same type
 * @author xuyifei
 *
 */
public interface Pairable<T> {
	T getFirst();
	T getSecond();
	void changeOrder();
	
	

}
