package ShopingCar;

public class Client {
	public static void main(String args[]){
		ShopCar shopcar = new ShopCar();
		shopcar.addGoods(new Item("��е����",750,1));
		shopcar.addGoods(new Item("���",56,10));
		shopcar.addGoods(new Item("����",110,2));
		shopcar.calculateTotal();
		
		PaymentStrategy wechat = new WeChatStrategy("΢��֧��","222016");
		shopcar.pay(wechat);
		
		PaymentStrategy credit = new CreditCardStrategy("���ÿ�֧��","2220162682");
		shopcar.pay(credit);
	}

}
