package Observer;
import java.util.ArrayList;
public class GoodsSubject implements Subject{
	ArrayList<Oberver> userList = new ArrayList<Oberver>();
	private String name;
	private double price;

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(Oberver o : userList){
			o.update();
		}
		
	}
	@Override
	public void registerObserver(Oberver o) {
		// TODO Auto-generated method stub
		if(!userList.contains(o)){
			userList.add(o);
		}
		
	}

	@Override
	public void unRegisterObserver(Oberver o) {
		// TODO Auto-generated method stub
		if(userList.contains(o)){
			userList.remove(o);
		}
		
	}
	
	public void distributeMsg(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	public String getName(){
		return this.name;
	}
	public double getPrice(){
		return this.price;
	}

}
