package ChainOR;

public class User {
	String name;
	String pwd;
	String ip;
	boolean blackList;
	public User(String name, String pwd, String ip, boolean blaskList){
		this.name = name;
		this.pwd = pwd;
		this.ip = ip;
		this.blackList = blaskList;
	}
	public void setBlack(boolean black){
		this.blackList = black;
	}
	public boolean getBlack(){
		return this.blackList;
	}
	

}
