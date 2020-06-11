#ifndef __SUBJECT__
#define __SUBJECT__
#include<vector>
#include"observer.h"
class subject
{
private:
	int value;
	vector<observer*> obs;
public:
	subject(int v=0):value(v){}
	void attach(observer* obj){ obs.push_back(obj);}
	void set_value(int v);
private:
	void __notify();
};
inline void
subject::set_value(int v)
{
	this->value = v;
	__notify();
}
inline void
subject::__notify()
{
	for(int i=0; i<obs.size(); ++i)
		obs[i]->update(this,value);
}

#endif
