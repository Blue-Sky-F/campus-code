#ifndef __PRINT__
#define __PRINT__

#include<iostream>
#include<list>
#include<string>
using namespace std;
void print(){
}
template<class T, class... U>
void print(const T& first, const U&... args)
{
	cout<<first<<endl;
	cout<<sizeof...(args)<<endl;
	print(args...);
}

int main()
{	list<string> ls;
	ls.push_back("hello");
	ls.push_back("world");
	string s = "hello";
	for(auto a:ls)
		cout<<a;
	
	print("hello","Sunday",3.5,"world",new int);
}





#endif
