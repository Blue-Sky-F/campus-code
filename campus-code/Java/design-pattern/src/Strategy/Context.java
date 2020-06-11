package Strategy;

public class Context {
	Strategy strategy;
	Context(Strategy s){
		this.strategy = s;
	}
	public float algorithm(int a, int b){
		return this.strategy.algorithm(a,b);
	}

}
