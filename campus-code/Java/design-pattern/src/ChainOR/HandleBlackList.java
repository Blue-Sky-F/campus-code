package ChainOR;

public class HandleBlackList extends Handler{

	@Override
	public void handleRequest(User user) {//�ж��Ƿ�Ϊ�������û��Ľӿ�
		// TODO Auto-generated method stub
		if(user.blackList){
			System.out.println("�������û����ܾ����ʣ�");
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
