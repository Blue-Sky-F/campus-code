package Observer;

public class User1 implements Oberver {
	Subject subject;
	public User1(Subject sub){
		this.subject = sub;
		subject.registerObserver(this);
	}
	
	public void update(){
		GoodsSubject gs = (GoodsSubject)subject;
		if(gs.getName().equals("Cherry����")&gs.getPrice()<800){//����Cherry���̷������Ҽ۸�����800ʱ����ʾ����
			System.out.println("�¿�Cherry�������ϼܣ�");
			System.out.print(gs.getName()+"\t");
			System.out.println(gs.getPrice()+"Ԫ");
		}
	}

}
