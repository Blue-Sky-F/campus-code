// test.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdio.h>
#include <malloc.h>
#define N 15 //数组长度
int main(int argc, char* argv[])
{	void popSort(int a[], int length);
	void selectSort(int a[], int length);
	void reverse(int a[],int re[], int length);
	void insertSort(int a[], int length);
	void print(int a[], int length);
	void selectSort_pro(int a[], int length);
	void popSort_pro(int a[], int length);
	void insertSort_pro(int a[], int length);


	int a[N], reva[N];//声明两个数组，reva用于存储a数组的逆序列
	for (int i=0; i<N; i++){
		a[i] = N-i;
	}
	for(i=0; i<N; i++){
		printf("%d\t",&a[i]);
	}
	/*
	1、改变N的值，发现数组a的最后一个元素的地址为定值1703740
	2、数组存储空间和其它基本数据类型的存储空间分布在两段连续的内存空间里
	3、数组和其它基本数据类型的变量存储在“栈”内存里 ，C系统在“栈”内存里分配空间是从高位地址往低位地址分配的
	*/
	void (* fun) (int[], int);
	void (* fun1) (int[], int);
	fun1 = &selectSort;
	fun = &print;
	printf("%d\n",sizeof(&a[0]));
	int m,n,p;
	int * q;
	printf("%d\t%d\t%d\t",&m,&n,&p);
	printf("%d\t%d\t%d\t%d",sizeof(q),&q,fun,fun1);
	printf("\n%d\t%d",sizeof(fun),sizeof(fun1));
	//printf("\n--------------------------------The source data------------------------------\n");
	//print(a,N);
	//selectSort_pro(a,N);//选择排序
	//popSort_pro(a,N);//冒泡排序
	//insertSort_pro(a,N);//直接选择排序
	//reverse(a,reva,N);
	printf("\n按任意键继续…"); 
	getchar(); 
	return 0;
}

void print(int a[], int length){
	for(int i=0; i<length; i++){
		printf("%d\t",a[i]);
		if((i+1)%10==0)
			printf("\n");
	}
	printf("\n");
}

void selectSort(int a[], int length){
	for(int i=0; i<length-1; i++){
		int min = i;
		for(int j=i+1; j<length; j++){
			if(a[min]>a[j])
				min = j;
		}
		int temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}
}
void selectSort_pro(int a[], int length){
		printf("----------------------------------Chose selectSorting method------------------------\n");
		for(int i=0; i<length-1; i++){
			int min = i;
			for(int j=i+1; j<length; j++){
				if(a[min]>a[j])
				min = j;
			}
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
			printf("Times %d\tof Sorting result:\n",i+1);
			print(a,length);
		}
}
void popSort(int a[], int length){
	for(int i=0; i<length-1; i++){
		for(int j=length-1; j>i; j--){
			if(a[j]<a[j-1]){
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
			}
		}
	}
}
void popSort_pro(int a[], int length){
	printf("----------------------------------Chose popSorting method------------------------\n");
	for(int i=0; i<length-1; i++){
		for(int j=length-1; j>i; j--){
			if(a[j]<a[j-1]){
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
			}
		}
		printf("Times %d\tof Sorting result:\n",i+1);
		print(a,length);
	}
}	
void insertSort(int a[], int length){
	for(int i=1; i<length; i++){
		for(int j=0; j<i; j++){
			if(a[i]>=a[j])
				continue;
			int tag = i-1;
			int tem = a[i];
			while(tag>=j){
				a[tag+1] = a[tag];
				tag--;
			}
			a[j] = tem;
		}
	}
}
void insertSort_pro(int a[], int length){
	printf("----------------------------------Chose insertSorting method------------------------\n");
	for(int i=1; i<length; i++){
		for(int j=0; j<i; j++){
			if(a[i]>=a[j])
				continue;
			int tag = i-1;
			int tem = a[i];
			while(tag>=j){
				a[tag+1] = a[tag];
				tag--;
			}
			a[j] = tem;
		}
		printf("Times %d\tof Sorting result:\n",i+1);
		print(a,length);
	}
}
	
void reverse(int a[],int re[], int length){
	for(int i=length-1; i>=0; i--)
		re[length-i-1] = a[i];
}

void chose(int n,int a[], int length){
	switch(n){
		case 0:
			selectSort_pro(a,length);
		case 1:
			popSort_pro(a,length);
		case 2:
			insertSort_pro(a,length);
	}
}
