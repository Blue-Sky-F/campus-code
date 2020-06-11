package ChainOR;

public class Client {
	public static void main(String args[]){
		User user1 = new User("Bob","Bob","12345",false);
		User user2 = new User("Alice","Alice","123456",true);
		User user3 = new User("John","john","123456",false);
		User user4 = new User("Eason","Eason","123456",false);
		HandleIP handler = new HandleIP();
		handler.handleRequest(user1);
		handler.handleRequest(user2);
		handler.handleRequest(user3);
		handler.handleRequest(user4);
	}

}
