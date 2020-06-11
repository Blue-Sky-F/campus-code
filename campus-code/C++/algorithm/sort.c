#include <stdio.h>
#define INT_MAX 2147483647
//直接插入排序
void insert_sort(int arr[], int length){
	for (int i=1; i<length; i++){
		int key = arr[i];
		int j = i-1;
		while(j>=0&&arr[j]>key){
			arr[j+1] = arr[j];
			j--;
			}
	arr[j+1] = key;
	}
}
//采用二分查找的直接插入排序
void insert_sort_bs(int arr[], int length){
	int bisearch(int arr[], int target, int length);
	for(int i=1; i<length; i++){
		int key = arr[i];
		int j = i-1;
		int position = bisearch(arr,key,j+1);
		if(position!=-1){
			for(int t=j; t>position; t--)
				arr[t+1] = arr[t]; 
			arr[position+1] = arr[i];
		}
		else{
			while(j>=0&&arr[j]>key){
			arr[j+1] = arr[j];
			j--;
			}
		arr[j+1] = key;
		}
	}
}
//希尔排序
void shell_sort(int arr[], int gap, int length){
	while(gap>=1){
		for (int i=1; i<length; i+=gap){
			int key = arr[i];
			int j = i-gap;
			while(j>=0&&arr[j]>key){
				arr[j+gap] = arr[j];
				j-=gap;
				}
		arr[j+gap] = key;
		}
		gap = gap-1;	
	}
}	
//冒泡排序
void pop_sort(int arr[], int length){
	for(int i=0; i<length; i++){
		for(int j=length-1; j>i; j--){
			if(arr[j]<arr[j-1]){
				int tem = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = tem;
			}
		}
	}
}
//选择排序
void select_sort(int arr[], int length){
	for(int i=0; i<length; i++){
		int index=i;
		int min = arr[i];
		for(int j=i+1; j<length-1; j++){
			if(arr[j]<min){
				min = arr[j];
				index = j;
			}		
		}
		int tem = arr[i];
		arr[i] = arr[index];
		arr[index] = tem;
	}
}
void merge(int arr[], int p ,int q, int r){
	int len1 = q-p+2;
	int len2 = r-q+1;
	int arr1[len1],arr2[len2];
	for (int i=p; i<q+1;i++){
		arr1[i-p] = arr[i];
		}
	for(int j=q+1; j<r+1;j++){
		arr2[j-q-1] = arr[j];
		}
	arr1[len1-1] = INT_MAX;
	arr2[len2-1] = INT_MAX;
	for(int i=0,j=0,s=p;s<=r;s++){
		if(arr1[i]>arr2[j]){
			arr[s] = arr2[j];
			j++;
		}
		else{
			arr[s] = arr1[i];
			i++;
		}
	}
}
//归并排序	
void merge_sort(int arr[], int p, int r){
	if(p<r){
		int q = (p+r)/2;
		merge_sort(arr,p,q);
		merge_sort(arr,q+1,r);
		merge(arr,p,q,r);
	}
}
//折半查找
int bisearch(int arr[], int target, int length){
	int start = 0;
	int end = length-1;
	int mid = (start+end)/2;
	while(start<=end){
		mid = (start+end)/2;
		if(arr[mid] == target)
			return mid;
		if(arr[mid]<target){
			start = mid+1;
			mid = (start+end)/2;
		}
		else{
			end = mid-1;
			mid = (start+end)/2;
		}
	}
	return -1;//目标元素不存在
}
//快速排序
void quick_sort(int arr[], int left, int right){
	if(left>=right)
		return ;
	int i = left, j= right;
	int key = arr[left];
	while(i<j){
	    while(i<j&&arr[j]>=key)
		j--;
	    arr[i] = arr[j];
	while(i<j&&arr[i]<=key)
		i++;
	    arr[j] = arr[i];
	}
	arr[j] = key;
	quick_sort(arr,left,j-1);
	quick_sort(arr,j+1,right);
}
void swap(int arr[], int i ,int j){
	int tem = arr[i];
	arr[i] = arr[j];
	arr[j] = tem;
}	
void min_heapify(int arr[], int size, int currentNode){
	int leftChild, rightChild, minimum;
	leftChild = 2*currentNode+1;
	rightChild = 2*currentNode+2;
	if(leftChild<size && arr[leftChild]<arr[currentNode])
		minimum = leftChild;
	else
		minimum = currentNode;
	if(rightChild<size && arr[rightChild]<arr[minimum])
		minimum = rightChild;
	if(minimum!=currentNode){
		swap(arr,minimum,currentNode);
		min_heapify(arr,size,minimum);
	}
}
void min_heap_create(int arr[], int size){
	for(int i=size/2; i>=0; i--)
		min_heapify(arr,size,i);
}
//最小堆排序
void min_heap_sort(int arr[], int size){
	for(int i=size;i>1; i--){
		min_heap_create(arr,i);
		swap(arr,0,i-1);
	}
}
void max_heapify(int arr[], int size, int currentNode){
	int leftChild, rightChild, max;
	leftChild = 2*currentNode+1;
	rightChild = 2*currentNode+2;
	if(leftChild<size && arr[leftChild]>arr[currentNode])
		max = leftChild;
	else
		max = currentNode;
	if(rightChild<size && arr[rightChild]>arr[max])
		max = rightChild;
	if(max!=currentNode){
		swap(arr,max,currentNode);
		max_heapify(arr,size,max);
	}
}
void max_heap_create(int arr[], int size){
	for(int i=size/2; i>=0; i--)
		max_heapify(arr,size,i);
}	
//最大堆排序
void max_heap_sort(int arr[], int size){
	for(int i=size;i>1; i--){
		max_heap_create(arr,i);
		swap(arr,0,i-1);
	}
}			
			

