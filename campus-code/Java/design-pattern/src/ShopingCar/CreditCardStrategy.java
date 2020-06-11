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
	public boolean cardMeetCode(){//验证账号、密码接口
		if(this.cardNumber.equals(this.code))
			return true;
		return false;
	}

	public void pay(double money){ //信用卡支付接口
		System.out.println("以"+this.name+"方式支付,原"+money+"元\t"+"优惠3元\t\t共"+ (money-3) +"元");
		
	}

}
