package ChainOR;

public class HandleLogin extends Handler{

	@Override
	public void handleRequest(User user) {//�ж��û����������Ƿ�ƥ��Ľӿ�
		// TODO Auto-generated method stub
		if(user.name.endsWith(user.pwd)){
			System.out.println("��¼�ɹ�����ӭ���ʱ�վ��");
			this.setTag(true);
		}
		else
			System.out.println("�û�����������������ԣ�");
		
		
	}

	@Override
	public void setSuccessor() {
		// TODO Auto-generated method stub
		
		
	}

}
