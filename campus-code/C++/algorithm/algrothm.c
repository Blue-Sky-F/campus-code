#include<stdio.h>
#include<string.h>
//长度为n的数组，元素数字在0--n-1范围内，找出任意一个重复数字,否则返回-1
int fun1(int arr[],int n){
	for(int i=0; i<n; i++){
		int number = arr[i];
		if(number==arr[number]&&i!=number)
			return number;
		int tem = arr[number];
		arr[number] = arr[i];
		arr[i] = tem;
	}	
	return -1;
}
//汉诺塔问题
void handot(int n, char from, char buff, char end){
	if(n==1){
		printf("From %c To %c\n",from,end);
		return;
	}
	handot(n-1,from,end,buff);
	handot(1,from,buff,end);
	handot(n-1,buff,from,end);
}
//错位重排公式
long dis_rearrange(int n){
	if(n==2)
		return 1;
	if(n<2)
		return 0;
	return(n-1)*(dis_rearrange(n-1)+dis_rearrange(n-2));
}
