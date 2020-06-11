package Bulider;
import java.util.ArrayList;
import java.util.List;
public abstract class Product {
	protected List<String> parts = new ArrayList<String>();
	public void add(String part){//添加部件
		parts.add(part);
	}
	public void show(){
		System.out.println("产品部件信息：");
		for(String part : parts){
			System.out.print(part+"\t");
		}
	}
	

}
