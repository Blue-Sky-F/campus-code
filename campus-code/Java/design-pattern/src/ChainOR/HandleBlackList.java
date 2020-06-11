package ChainOR;

public class HandleBlackList extends Handler{

	@Override
	public void handleRequest(User user) {//判断是否为黑名单用户的接口
		// TODO Auto-generated method stub
		if(user.blackList){
			System.out.println("黑名单用户，拒绝访问！");
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
		this.handler = new HandleLogin();
		
	}

}
