package ChainOR;

public abstract class Handler {
	public Handler handler;
	boolean tag = false;//��ʶ����1��ʾ��������ϣ�0��ʾ��Ҫ��������
	public abstract void handleRequest(User user);
	public abstract void setSuccessor();
	public void setTag(boolean tag){
		this.tag =tag;
	}
	public boolean getTag(){
		return this.tag;
	}

}
