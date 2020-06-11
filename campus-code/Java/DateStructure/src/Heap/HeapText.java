package Heap;

public class HeapText {
	public static void main(String args[]){
		Heap heap = new Heap(100);
		for(int i =1;i<100;i++){
			heap.insert(i);
		}
		for(int i=1;i<100;i++){
			System.out.print(heap.element[i]+"\t");
		}
		for(int i=1;i<50;i++){
			heap.delete();
		}
		System.out.println();
		for(int i=1;i<49;i++){
			System.out.print(heap.element[i]+"\t");
		}
//		heap.insert(3);
//		heap.insert(5);
//		heap.insert(8);
//		heap.insert(10);
//		System.out.println(heap.size);
//		//System.out.println(heap.element[0]);
//		System.out.println(heap.element[1]);
//		System.out.println(heap.element[2]);
//		System.out.println(heap.element[3]);
//		System.out.println(heap.element[4]);
//		System.out.println(heap.element[5]);
//		System.out.println(heap.element[6]);
//		heap.delete();
//		System.out.println(heap.element[1]);
//		heap.delete();
//		System.out.println(heap.element[1]);
		
	}

}
