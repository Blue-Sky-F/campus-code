#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include"sort.c"
#include"algrothm.c"
#define N 10
struct Student{
	char name[10];
	int age;
	};
struct Student get(){
	struct Student s={"hello",13};
	return s;//可以将局部变量用值传递的方式作为返回结果
}
/**struct Student* get1(){
	struct Student s={"hello",13};
	return &s;//编译错误，不能将一个局部变量的地址作为函数返回结果
}*/
int* fun3(){
	int* arr = malloc(sizeof(int)*4);//堆内存，可以作为地址返回
	arr[0] =1;
	arr[2] = 2;
	arr[3] = 23;
	arr[1] = 0;
	return arr;
}

int main(){
	/**int array[N];
	for(int i=0; i<N; i++){
		array[i] = rand()%10000;
		}*/
	
	//int arr[5] = {23,32,43,234,234};
	//for(int i=0,j=0,s=0; i<N; i++)printf("%d  ",array[i]);
	//printf("\n");
	//insert_sort(array,N);	
	//merge_sort(array,0,N-1);
	//pop_sort(array,N);
	//select_sort(array,N);
	//shell_sort(array,32,N);
	//quick_sort(array,0,N-1);
	//min_heap_sort(array,N);
	//max_heap_sort(array,N);
	//for(int i=0; i<N; i++)printf("%d  ",array[i]);
	//handot(4,'A','B','C');
	
}
