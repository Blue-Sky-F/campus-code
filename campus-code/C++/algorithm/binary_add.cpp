#include<stdio.h>
int main(){
	void binary_add(int a[], int b[], int c[],int n);
	void travel(int tag, int a[], int b[], int c[], int i);
	int a[8] = {1,0,1,0,1,1,1,0};
	int b[8] = {0,1,0,0,1,0,0,1};
	int c[9];
	binary_add(a,b,c,7);
	//travel(0,a,b,c,7);
	for (int i=0; i<9; i++){
		printf("%d",c[i]);
		}
	return 0;
}

//将两个整形数用整形数组a，b二进制表示，运行加法，结果保存在C中
void binary_add(int a[], int b[], int c[],int n){
int tag = 0;
for (int i=n; i>=0; i--){
	int add = a[i] + b[i];
	if(add ==0){
		if(tag==0){
		c[i+1] = 0;
		}
		else{
		c[i+1] = 1; tag = 0;
		}
		}
	 else if(add ==1){
		if(tag==0){
			c[i+1] = 1;
			}
		else{
			c[i+1] = 1;
			}
		}
	 else{
		if(tag==0){
			c[i+1] = 0; tag=1;
			}
		else{
			c[i+1] = 1;
			}
		}
	}
if(tag==0){
	c[0] = 0;
	}
else{
	c[0] = 1;
	}
}
//上述算法的递归实现
void travel(int tag, int a[], int b[], int c[], int i){
	if(i>=0){
		int add = a[i]+b[i];
		if(add==0){
			if(tag==0){c[i+1] = 0;}
			else{c[i+1]=1; tag=0;}
			}
		else if(add==1){
			if(tag==0){c[i+1] = 1;}
			else{c[i+1]=0; tag=1;}
			}
		else{
			if(tag==0){c[i+1] = 0;tag=1;}
			else{c[i+1]=1;}
			}
		travel(tag,a,b,c,i-1);
		}
	else{
		if(tag==1){c[0] =1;}
		else{c[0] =0;}
		}
		
}
			

