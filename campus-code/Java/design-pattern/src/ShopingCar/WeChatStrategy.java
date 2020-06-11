package ShopingCar;

public class WeChatStrategy implements PaymentStrategy{
	String name;
	String cardNumber;
	String code;
	WeChatStrategy(String n, String c){
		this.name = n;
		this.cardNumber = c;
	}
	public void setCardNumber(String cardNumber){
		this.cardNumber = cardNumber;
	}
	public void setCode(String code){
		this.code = code;
	}
	public boolean cardMeetCode(){//��֤�˺š�����ӿ�
		if(this.cardNumber.equals(this.code))
			return true;
		return false;
	}

	public void pay(double money){ //΢�ſ�֧���ӿ�
		System.out.println("��"+this.name+"��ʽ֧��,ԭ"+money+"Ԫ\t"+"9.9���Ż�\t��"+money*0.99+"Ԫ");
		
	}

}
