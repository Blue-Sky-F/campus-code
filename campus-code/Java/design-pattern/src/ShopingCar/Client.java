package ShopingCar;

public class Client {
	public static void main(String args[]){
		ShopCar shopcar = new ShopCar();
		shopcar.addGoods(new Item("机械键盘",750,1));
		shopcar.addGoods(new Item("鼠标",56,10));
		shopcar.addGoods(new Item("键盘",110,2));
		shopcar.calculateTotal();
		
		PaymentStrategy wechat = new WeChatStrategy("微信支付","222016");
		shopcar.pay(wechat);
		
		PaymentStrategy credit = new CreditCardStrategy("信用卡支付","2220162682");
		shopcar.pay(credit);
	}

}
