package Stack;

public class Stack<T> {
	 T date[];
     int top;
	 public Stack(int n){
		date=(T[])new Object[n];
		top=0;
	}
	public int push(T t){
		if(top>=date.length){
			return -1;
	}
		else{
			top++;
			date[top]=t;
			return 1;
		}
  }
	public T pop(){
		if(top==0){
			return null;
		}
		else{
			T pop=date[top];
			top--;
			return pop;
		}
	}
	

}
