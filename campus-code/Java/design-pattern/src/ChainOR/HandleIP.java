package ChainOR;

public class HandleIP extends Handler{

	@Override
	public void handleRequest(User user) {//�ж�ip��ַ�Ƿ�Ϸ��Ľӿ�
		// TODO Auto-generated method stub
		if(user.ip.endsWith("12345")){//�Ƿ�IP
			System.out.println("�Ƿ�IP���ܾ����ʣ�");
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
