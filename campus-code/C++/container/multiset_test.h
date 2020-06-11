#ifndef __CONTAINER_TEST__
#define __CONTAINER_TEST__
#include<string>
#include<set>
#include<iostream>
#include<stdexcept>
#include<ctime>
#include<vector>
#include<cstdlib>  //abort()
#include<cstdio>  //snprintf();
#include<algorithm>
using namespace std;
string get_a_target_string()
{
string c;
	cout <<"choice a target string:"<<endl;
	cin >> c;
	return c;
}
void test_multiset(long& value)
{
	cout<<"test_multiset()......\n";
multiset<string> c;
char buf[10];
clock_t timeStart = clock();
	for(long i=0; i<value; ++i){
		try{
			snprintf(buf,10,"%d",rand());
			c.insert(string(buf));
		}
		catch(exception& p){
			cout<<"i="<<i<<" "<<p.what()<<endl;
			abort();
		}
	}
	cout <<"milli-seconds: " <<(clock()-timeStart)<<endl;
	cout <<"multiset-size: " <<c.size() <<endl;
	cout <<"multiset-max_size: " <<c.max_size()<<endl;
const string target = get_a_target_string();
	{
	timeStart = clock();
auto pItem = find(c.begin(),c.end(),target);
	cout <<"::find(),milli-seconds: "<<(clock()-timeStart)<<endl;
	if(pItem!=c.end())
		cout <<"found, "<<*pItem<<endl;
	else
		cout <<"not found! "<<endl;
	}
	{
	timeStart = clock();
auto pItem = c.find(target);
	cout <<"c.find(),milli-seconds: "<<(clock()-timeStart)<<endl;
	if(pItem!=c.end())
		cout <<"found, "<<*pItem <<endl;
	else
		cout <<"not found! "<<endl;
	}
}

#endif 
