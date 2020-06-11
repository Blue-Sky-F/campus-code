#include<stdio.h>
#define LENGTH 10
int main(){
	void fun(int posi,int * counts,int n);
	int *counts;
	int posi = 0;
	int b=0;
	counts = &b;
	fun(posi,counts,28);
	printf("%d",*counts);
	return 0;
	}
/**该算法计算编号为（1,2,... LENGTH-1）的圆环，初始位置为posi，走n步后回到初始位置的路径数
(每一步只允许前进一个编号或者后退一个编号)**/	
void fun(int posi,int * counts,int n){
	if(n>=1){
		posi = (posi+1)%LENGTH;//前进一步
		fun(posi,counts,n-1);
		posi = (posi-2)%LENGTH;//后退一步
		fun(posi, counts,n-1);
		}
	else{
	if(posi==0){(*counts)++;}
	}
}

