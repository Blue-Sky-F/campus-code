package ChainOR;

public class HandleLogin extends Handler{

	@Override
	public void handleRequest(User user) {//判断用户名和密码是否匹配的接口
		// TODO Auto-generated method stub
		if(user.name.endsWith(user.pwd)){
			System.out.println("登录成功！欢迎访问本站！");
			this.setTag(true);
		}
		else
			System.out.println("用户名或密码错误！请重试！");
		
		
	}

	@Override
	public void setSuccessor() {
		// TODO Auto-generated method stub
		
		
	}

}
