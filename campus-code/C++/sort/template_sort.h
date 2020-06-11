#include<iostream>
#include<vector> 
#include<ctime>
#include<string>
#include<stdexcept>
#include<algorithm>//sort()
#include<cstdlib>//abort()
#include<cstdio>//snprintf()
using namespace std;
template<class T> void sweap(T &a, T &b){
T tem = a;
    a = b;
    b = tem;
}
int cmpfunc(const void * a, const void * b){
   return ( *(int*)a - *(int*)b );
}
//bool compare_To(string &a, string &b){
//	return atoi(a.c_str())-atoi(b.c_str())>0?false: true;//string translate to int
//}
bool compare_To(int &a, int &b){
	return a-b>0?false: true;
}
template<class T> void pop_sort(vector<T> &entry){
int len = entry.size();
    for(int i=0; i<len-1; i++){
        for(int j=len-1; j>i; j--){
            if(entry[j]<entry[j-1])
                sweap<T>(entry[j-1],entry[j]);
        }
    }
}
template<class T> void select_sort(vector<T> &entry){
int len = entry.size();
    for(int i=0; i<len-1; i++){
        T tem = entry[i];
        int posi;
        for(int j=i+1; j<len; j++){
            if(entry[j]<tem){//可以通过要求T实现compareTo()方法,此行代码重构为entry[j].compareTo(tem)<0;
                tem = entry[j];
                posi = j;
            }
        }
        sweap(entry[i],entry[posi]);
    }
}
template<class T> void insert_sort(vector<T> &entry){
int len = entry.size();
    for(int i=1; i<len; i++){
        T new_en = entry[i];
        int j = i-1;
        while(j>=0&&entry[j]>new_en){
            entry[j+1] = entry[j];
            j--;
        }
        entry[j+1] = new_en;
    }
}
template<class T> void shell_sort(vector<T> &entry){
int len = entry.size();
int gap = 32;
    while(gap>=1){
        for(int i=1; i<len; i++){
            T new_en = entry[i];
            int j = i-gap;
            while(j>=0&&entry[j]>new_en){
                entry[j+gap] = entry[j];
                j-=gap;
            }
                entry[j+gap] = new_en;
        }
        gap/=2;
    }
}
template<class T> void merge(vector<T> &entry, int p, int q, int r){
	int len1 = q-p+1;
	int len2 = r-q;
	T arr1[len1], arr2[len2];
	for(int i=p; i<q+1; i++)
		arr1[i-p] = entry[i];
	for(int j=q+1; j<r+1; j++)
		arr2[j-q-1] = entry[j];
	int i = 0, j = 0, index = p;
	while(i<len1&&j<len2){
		if(arr1[i]>arr2[j])
			entry[index++] = arr2[j++];
		else
			entry[index++] = arr1[i++];
	}
	while(i<len1)
		entry[index++] = arr1[i++];
	while(j<len2)
		entry[index++] = arr2[j++]; 
}
template<class T> void merge_s(vector<T> &entry, int p, int r){
	if(p<r){
		int q = (p+r)/2;
		merge_s(entry,p,q);
		merge_s(entry,q+1,r);
		merge(entry,p,q,r);
	}
}
template<class T> void merge_sort(vector<T> &entry){
	merge_s(entry,0,entry.size()-1);
}
template<class T> void quick(vector<T> &entry, int left, int right){
	if(left>=right)
		return;
	int i= left, j = right;
	T key = entry[left];
	while(i<j){
		while(i<j&&entry[j]>=key)
			j--;
		entry[i] = entry[j];
		while(i<j&&entry[i]<=key)
			i++;
		entry[j] = entry[i];
	}
	entry[i] = key;
	quick(entry,left,j-1);
	quick(entry,j+1,right);
} 
template<class T> void quick_sort(vector<T> &entry){
	quick(entry,0,entry.size()-1);//以上排序都是弟弟 
}
		
			

