package Observer;

public class User2 implements Oberver{
	Subject subject;
	public User2(Subject sub){
		this.subject = sub;
		subject.registerObserver(this);
	}
	
	public void update(){
		GoodsSubject gs = (GoodsSubject)subject;
		if(gs.getName().equals("小米耳机")&gs.getPrice()<180){//当有小米耳机发布并且价格少于180时，显示更新
			System.out.println("新款小米耳机已上架：");
			System.out.print(gs.getName()+"\t"+"\t");
			System.out.println(gs.getPrice()+"元");
		}
		
		     }


}
