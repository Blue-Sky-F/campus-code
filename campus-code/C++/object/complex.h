#ifndef __COMPLEX__
#define __COMPLEX__
#include<iostream>
template<class T>
class complex
{
public:
	complex(T r=0, T i=0): re(r),im(i){}
	double real() 	const  {return re;}
	double imag() 	const  {return im;}
	void set_real(double re){this->re = re;}
	void set_imag(double im){this->im = im;}
	complex& operator += (const complex&);
	void operator = (const complex&); 
	void operator ++();
	friend complex& __doapl(complex*, const complex&);
private:
	T re, im;
};
template<class T>
inline complex<T>& 
__doapl(complex<T>* ths, const complex<T>& com)
{
	ths->re += com.re;
	ths->im += com.im;
	return *ths;
}
template<class T>
inline complex<T>&
complex<T>::operator +=(const complex<T>& com)
{
	return __doapl(this,com);
}
template<class T>
inline void
complex<T>::operator =(const complex<T>& com)
{
	this->set_imag(com.imag());
	this->set_real(com.real());
}
template<class T>
inline void
complex<T>::operator ++(){
	im++;
	re++;
}
template<class T>
inline complex<T> 
operator + (const complex<T>& x, const complex<T>& y)
{
	return complex<T>(x.real()+y.real(),x.imag()+y.imag());	
}
template<class T>
inline complex<T>
operator + (const complex<T>& x, const double r)
{
	return complex<T>(x.real()+r, x.imag());
} 
 template<class T>
 inline complex<T> 
 operator + (const double im, const complex<T>& x)
 {
 	return complex<T>(x.real(), x.imag()+im);
 }

using namespace std;
template<class T>
inline ostream& operator << (ostream& os, const complex<T>& x)
{
	return os<<"(" <<x.real() <<"," <<x.imag() <<")";
}
#endif
using namespace std;
class A
{
	public:
		A(){cout<< "Initialize A..."<<endl;}
};
class B:public A
{
	public:
		B(){cout<< "Initialize B..."<<endl;}
	private:
		A a;
};

