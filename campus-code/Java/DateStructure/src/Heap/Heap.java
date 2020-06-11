package Heap;

public class Heap {
	Integer element[];
	int size;//��ǰԪ�ظ���
	int capacity;
	
	//��ʼ��
	public Heap(int max){
		size = 0;
		capacity = max;
		element = new Integer[max];
		element[0] = 10000000;//�ڱ�
	}
	
	//����Ԫ��
	public boolean insert(int data){
		if(this.size==this.capacity){
			return false;
		}
		else{
			int i = ++size;
			element[i] = data;
			//���ϵ���
			for( ;data>element[i/2]; i=i/2){
				element[i] = element[i/2];
			}
			element[i] = data;
		
		}
		return true;
	}
	//ɾ��Ԫ��
	public int delete(){
		int parent,child=1;
		if(size==0){
			return -100;//��
		}
		int dele = element[1];
		int temp = element[size--];
		for(parent=1; parent*2<size; parent = child){
			child = parent*2;
			if(child!=size && element[child]<element[child+1]){
				child++;//ָ�����Һ���������Ǹ�
			}
			if(temp>element[child]){
			break;
		}
			else{
				element[parent] = element[child]; 
			}
			
	}
		element[parent] = temp;
		return dele;
	}


}
