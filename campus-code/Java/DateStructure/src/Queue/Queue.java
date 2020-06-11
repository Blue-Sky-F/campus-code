package Queue;
/**
 * ��װһ��Queue�࣬ʵ�ֶ��е����ݽṹ
 * @author �����
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
	 * ���
	 * @param data
	 * @return
	 */
	public int in(T data){
		if((rear+1)%this.data.length==front){//����
			return -1;
		}
		else{
			this.data[rear] = data;
			rear = (rear+1)%this.data.length;
			return 1;
		}
	}
	/**
	 * ����
	 * @param data
	 * @return
	 */
	public T out(){
		if(rear==front){//�ӿ�
			return null;
		}
		else{
			T date = this.data[front];
			front = (front+1)%this.data.length;
			return date;
			
		}
	}

}
