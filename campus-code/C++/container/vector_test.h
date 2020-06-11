#include<vector>
#include<string>
using namespace std;
void test_vector(long& value)
{
	cout<<"test_vector()......\n";
vector<string> c;
char buf[10];
clock_t timeStart = clock();
	for(long i=0; i<value; ++i){
		try{
			snprintf(buf,10,"%d",rand());
			c.push_back(string(buf));
		}
		catch(exception& p){
			cout<<"i="<<i<<" "<<p.what()<<endl;
			abort();
		}
	}
	cout <<"milli-seconds: " <<(clock()-timeStart)<<endl;
	cout <<"vector-size: " <<c.size() <<endl;
	cout <<"vector-max_size: " <<c.max_size()<<endl;
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
//	{
//	timeStart = clock();
//auto pItem = c.find(target);
//	cout <<"c.find(),milli-seconds: "<<(clock()-timeStart)<<endl;
//	if(pItem!=c.end())
//		cout <<"found, "<<*pItem <<endl;
//	else
//		cout <<"not found! "<<endl;
//	}
	
}	

