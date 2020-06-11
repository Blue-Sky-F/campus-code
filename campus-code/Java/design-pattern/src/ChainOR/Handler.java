package ChainOR;

public abstract class Handler {
	public Handler handler;
	boolean tag = false;//标识符，1表示请求处理完毕，0表示需要继续处理
	public abstract void handleRequest(User user);
	public abstract void setSuccessor();
	public void setTag(boolean tag){
		this.tag =tag;
	}
	public boolean getTag(){
		return this.tag;
	}

}
