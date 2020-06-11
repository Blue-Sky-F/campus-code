package Pairable;
/**
 * 
 * @author xuyifei
 * A class of ordered paiers of objects having the same date type
 * @param <T>
 */
public class OrderedPair<T> implements Pairable<T> {
	private T first;
	private T second;
	
	public OrderedPair(T first, T second){
		this.first = first;
		this.second = second;
	}
	@Override
	public void changeOrder() {
		// TODO Auto-generated method stub
		T tem = first;
		first = second;
		second = tem;
		
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return first;
	}

	@Override
	public T getSecond() {
		// TODO Auto-generated method stub
		return second;
	}
	public String toString(){
		return "("+first+","+second+")" ;
	}

}
