package Observer;

public class User1 implements Oberver {
	Subject subject;
	public User1(Subject sub){
		this.subject = sub;
		subject.registerObserver(this);
	}
	
	public void update(){
		GoodsSubject gs = (GoodsSubject)subject;
		if(gs.getName().equals("Cherry键盘")&gs.getPrice()<800){//当有Cherry键盘发布并且价格少于800时，显示更新
			System.out.println("新款Cherry键盘已上架：");
			System.out.print(gs.getName()+"\t");
			System.out.println(gs.getPrice()+"元");
		}
	}

}
