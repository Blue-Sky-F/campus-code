// test.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdio.h>
#include <malloc.h>
#define N 15 //���鳤��
int main(int argc, char* argv[])
{	void popSort(int a[], int length);
	void selectSort(int a[], int length);
	void reverse(int a[],int re[], int length);
	void insertSort(int a[], int length);
	void print(int a[], int length);
	void selectSort_pro(int a[], int length);
	void popSort_pro(int a[], int length);
	void insertSort_pro(int a[], int length);


	int a[N], reva[N];//�����������飬reva���ڴ洢a�����������
	for (int i=0; i<N; i++){
		a[i] = N-i;
	}
	for(i=0; i<N; i++){
		printf("%d\t",&a[i]);
	}
	/*
	1���ı�N��ֵ����������a�����һ��Ԫ�صĵ�ַΪ��ֵ1703740
	2������洢�ռ�����������������͵Ĵ洢�ռ�ֲ��������������ڴ�ռ���
	3����������������������͵ı����洢�ڡ�ջ���ڴ��� ��Cϵͳ�ڡ�ջ���ڴ������ռ��ǴӸ�λ��ַ����λ��ַ�����
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
	//selectSort_pro(a,N);//ѡ������
	//popSort_pro(a,N);//ð������
	//insertSort_pro(a,N);//ֱ��ѡ������
	//reverse(a,reva,N);
	printf("\n�������������"); 
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
