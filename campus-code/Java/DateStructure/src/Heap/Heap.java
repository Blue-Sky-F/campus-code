package Heap;

public class Heap {
	Integer element[];
	int size;//当前元素个数
	int capacity;
	
	//初始化
	public Heap(int max){
		size = 0;
		capacity = max;
		element = new Integer[max];
		element[0] = 10000000;//哨兵
	}
	
	//插入元素
	public boolean insert(int data){
		if(this.size==this.capacity){
			return false;
		}
		else{
			int i = ++size;
			element[i] = data;
			//向上调整
			for( ;data>element[i/2]; i=i/2){
				element[i] = element[i/2];
			}
			element[i] = data;
		
		}
		return true;
	}
	//删除元素
	public int delete(){
		int parent,child=1;
		if(size==0){
			return -100;//空
		}
		int dele = element[1];
		int temp = element[size--];
		for(parent=1; parent*2<size; parent = child){
			child = parent*2;
			if(child!=size && element[child]<element[child+1]){
				child++;//指向左右孩子中最大那个
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
