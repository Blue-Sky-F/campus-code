package Strategy;

public class Client {
	public static void main(String args[]){
		Context x = new Context(new ConcreteStrategyA());
		System.out.println(x.algorithm(22,2));
		
		Context y = new Context(new ConcreteStrategyB());
		System.out.println(y.algorithm(22,2));
		
		Context m = new Context(new ConcreteStrategyC());
		System.out.println(m.algorithm(22,2));
		
		Context n = new Context(new ConcreteStrategyD());
		System.out.println(n.algorithm(22,2));
	}

}
