package Queue;
/**
 * 封装一个Queue类，实现队列的数据结构
 * @author 徐翼飞
 *
 */
public class Queue<T> {
	private T data[];
	private int front;
	private int rear;

	public Queue(){
		data =(T[])new Object[10];
	    front = 0;
	    rear = 0;
	}
	public Queue(int max){
		data = (T[])new Object[max];
		front = 0;
		rear = 0;
	}
	/**
	 * 入队
	 * @param data
	 * @return
	 */
	public int in(T data){
		if((rear+1)%this.data.length==front){//队满
			return -1;
		}
		else{
			this.data[rear] = data;
			rear = (rear+1)%this.data.length;
			return 1;
		}
	}
	/**
	 * 出队
	 * @param data
	 * @return
	 */
	public T out(){
		if(rear==front){//队空
			return null;
		}
		else{
			T date = this.data[front];
			front = (front+1)%this.data.length;
			return date;
			
		}
	}

}
