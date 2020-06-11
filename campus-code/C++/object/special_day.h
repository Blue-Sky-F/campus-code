#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

class demo
{
private:
	int d;
public:
	demo():d(0){}
	int get_d() const;
	void set_d(const int);
};
int demo::get_d() const
{	
	return d;
}
void demo::set_d(const int i)
{	
	d = i;
}
bool verified(string s){	
	int month = stoi(s.substr(0,2));
	int day = stoi(s.substr(2,4));
	return (month>0 && month<13 && day>0 && day<31);
}

void world_symmetrical_day(){
	cout<<"�����͵�������ȫ�Գ��գ�"<<endl;
	for(int i=2000; i<2100; ++i){
		string s = to_string(i);
		string n = s;
		reverse(s.begin(),s.end());
		if(n=="2020")
			cout<<"  "<<n<<"��"<<s.substr(0,2)<<"��"<<s.substr(2,4)<<"��"<<" (Today!)"<<endl;
		else if(verified(s))
			cout<<"  "<<n<<"��"<<s.substr(0,2)<<"��"<<s.substr(2,4)<<"��"<<endl;		
	}
}


