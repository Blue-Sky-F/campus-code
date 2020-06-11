#ifndef __OBSEVER__
#define __OBSEVER__
#include<iostream>
#include<vector>
#include"subject.h"
class subject;//declar class subject.
class observer
{
public:
	virtual void update(subject*, int);	
};
void observer::update(subject* s, int value)
{
	std::cout<<"default update..."<<std::endl;
}

class observerA :public observer
{
public:
	virtual void update(subject* s, int v){
		std::cout<<"observerA updates..."<<std::endl;
	}
};

class observerB :public observer
{
public:
	virtual void update(subject* s, int v){
		std::cout<<"observerB updates..."<<std::endl;
	}
};

#endif
