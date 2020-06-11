#include<stdio.h>
int sum=0;
void swap(int arr[], int i, int j){
	int tem = arr[i];
	arr[i] = arr[j];
	arr[j] = tem;
}	
void allOrder(int arr[], int left, int right){
	if(left==right){
		for(int i=0; i<right; i++){
			printf("%d  ",arr[i]);
		}
		sum++;
		printf("\n");
	}
	else{
		for(int i=left; i<right; i++){
			swap(arr,left,i);
			allOrder(arr,left+1,right);
			swap(arr,i,left);
		}
	}

}

