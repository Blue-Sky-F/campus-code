#include<map>
#include<string>
using namespace std;
long get_a_target_long()
{
long c;
	cout <<"choice a target long:"<<endl;
	cin >> c;
	return c;
}
void test_map(long& value)
{
	cout<<"test_map()......\n";
map<int,string> c;
char buf[10];
clock_t timeStart = clock();
	for(long i=0; i<value; ++i){
		try{
			snprintf(buf,10,"%d",rand());
			c[i] = string(buf);
		}
		catch(exception& p){
			cout<<"i="<<i<<" "<<p.what()<<endl;
			abort();
		}
	}
	cout <<"milli-seconds: " <<(clock()-timeStart)<<endl;
	cout <<"map-size: " <<c.size() <<endl;
	cout <<"map-max_size: " <<c.max_size()<<endl;
const long target = get_a_target_long();
//	{
//	timeStart = clock();
//auto pItem = find(c.begin(),c.end(),target);
//	cout <<"::find(),milli-seconds: "<<(clock()-timeStart)<<endl;
//	if(pItem!=c.end())
//		cout <<"found, "<<*pItem<<endl;
//	else
//		cout <<"not found! "<<endl;
//	}
	{
	timeStart = clock();
auto pItem = c.find(target);
	cout <<"c.find(),milli-seconds: "<<(clock()-timeStart)<<endl;
	if(pItem!=c.end())
		cout <<"found, "<<(*pItem).second<<endl;
	else
		cout <<"not found! "<<endl;
	}
}
