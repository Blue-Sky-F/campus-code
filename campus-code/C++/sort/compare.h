#include<iostream>
#include<string>
using namespace std;
template<class T> bool compare(const T &s1, const T &s2){
	return s1.size()<s2.size();
}

