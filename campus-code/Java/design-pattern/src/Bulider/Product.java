package Bulider;
import java.util.ArrayList;
import java.util.List;
public abstract class Product {
	protected List<String> parts = new ArrayList<String>();
	public void add(String part){//��Ӳ���
		parts.add(part);
	}
	public void show(){
		System.out.println("��Ʒ������Ϣ��");
		for(String part : parts){
			System.out.print(part+"\t");
		}
	}
	

}
