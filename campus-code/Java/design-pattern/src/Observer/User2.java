package Observer;

public class User2 implements Oberver{
	Subject subject;
	public User2(Subject sub){
		this.subject = sub;
		subject.registerObserver(this);
	}
	
	public void update(){
		GoodsSubject gs = (GoodsSubject)subject;
		if(gs.getName().equals("С�׶���")&gs.getPrice()<180){//����С�׶����������Ҽ۸�����180ʱ����ʾ����
			System.out.println("�¿�С�׶������ϼܣ�");
			System.out.print(gs.getName()+"\t"+"\t");
			System.out.println(gs.getPrice()+"Ԫ");
		}
		
		     }


}
