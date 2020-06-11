package ShopingCar;

public class CreditCardStrategy implements PaymentStrategy{
	String name;
	String cardNumber;
	String code;
	CreditCardStrategy(String n, String c){
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

	public void pay(double money){ //���ÿ�֧���ӿ�
		System.out.println("��"+this.name+"��ʽ֧��,ԭ"+money+"Ԫ\t"+"�Ż�3Ԫ\t\t��"+ (money-3) +"Ԫ");
		
	}

}
