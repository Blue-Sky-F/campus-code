package ChainOR;

public class HandleIP extends Handler{

	@Override
	public void handleRequest(User user) {//判断ip地址是否合法的接口
		// TODO Auto-generated method stub
		if(user.ip.endsWith("12345")){//非法IP
			System.out.println("非法IP，拒绝访问！");
			this.setTag(true);
		}
		else{
			this.setSuccessor();
			this.handler.handleRequest(user);
		}
		
	}

	@Override
	public void setSuccessor() {
		// TODO Auto-generated method stub
		this.handler = new HandleBlackList();
		
		
	}
	

}
