package Observer;

public class Client {
	public static void main(String args[]){
		GoodsSubject sb = new GoodsSubject();
		User1 bob = new User1(sb);
		User1 tom = new User1(sb);
		User2 alice = new User2(sb);
		sb.distributeMsg("Cherry����", 650.00);
		sb.notifyObserver();
		sb.distributeMsg("С�׶���", 175);
		sb.notifyObserver();
	}

}
