#include<stdio.h>
//存储一个进程的开始时间，运行时间，结束时间
struct Process{
		int start;
		int run;
		int end;
		};
    
int main(){
	void fcfs(struct Process p[],int n);
	void short_first(struct Process p[],int n);
	_Bool finish(struct Process p[],int n);
	void pop_sort(int array[], int n);
	void pop_sort_re(int array[], int n);
	void print(int arr[], int n);
	struct Process ps[4] = {0,2,2,2,10,12,3,5,8,6,4,10};
	int arr[10]={232,23,4,323,42,34,2323,3243,423,423};
	pop_sort_re(arr,10);
	print(arr,10);
	//fcfs(ps,3);
	//short_first(ps,4);
	/*for(int i=0; i<4; i++){
		printf("%d,%d,%d\t",ps[i].start,ps[i].run,ps[i].end);
		}
	*/
}
//先来先服务算法
void fcfs(struct Process p[],int n){
	if(n>=1){
		fcfs(p,n-1);
		p[n].start = p[n-1].end;
		p[n].end = p[n].start+p[n].run;
			}
}

//最短作业优先算法
void short_first(struct Process p[],int n){
	void print(int arr[], int n);
	//生成断点
	int point[2*n];
	for(int i=0,j=0; i<n; i++){
		point[j] = p[i].start;
		point[j+1] = p[i].end;
		j+=2;
		} 
	//断点排序
	for(int i=0; i<2*n-1; i++){
		for(int j=2*n-1; j>i; j--){
			if(point[j]<point[j-1]){
				int tem = point[j];
				point[j] = point[j-1];
				point[j-1] = tem;
				}
			}
		}
	
	for(int i=0; i<(2*n);i++){
		printf("%d  ",point[i]);
		}
	//while(!finish(p,n){
		
	//}
}	
_Bool finish(struct Process p[],int n){
	for(int i=0; i<n; i++){
		if(p[i].run>0)
			return 0;
		}
	return 1;
}
void pop_sort(int array[], int n){
	for(int i=0; i<n-1; i++){
		for(int j=n-1; j>i; j--){
			if(array[j]<array[j-1]){
				int tem = array[j];
				array[j] = array[j-1];
				array[j-1] = tem;
			}
		}
	}	
}	
void pop_sort_re(int array[], int n){
	for(int i=n-1; i>0; i--){
		for(int j=0; j<i; j++){
			if(array[j]<array[j+1]){
				int tem = array[j];
				array[j] = array[j+1];
				array[j+1] = tem;
			}
		}
	}	
}	
void print(int arr[], int n){
	for(int i=0; i<n; i++){
		printf("%d  ",arr[i]);
	}
}	
				
