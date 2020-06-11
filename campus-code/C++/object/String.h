#ifndef __STRING__
#define __STRING__
#include<string.h>
class String
{
public:
	String(const char*);
	String(const String& str);
	String& operator =(const String& str);
	~String();
	char* get_c_str() const {return m_data;}
	int length() const;
private:
	char* m_data;	
};

inline String::String(const char* cstr =0)
{
	if(cstr){
		this->m_data = new char(strlen(cstr)+1);
		strcpy(this->m_data, cstr);	
	}
	else{
		this->m_data = new char[1];
		*this->m_data = '\0';
	}
	
}
inline String::String(const String& str)
{
	this->m_data = new char[strlen(str.get_c_str())+1];
	strcpy(this->m_data,str.m_data);
}
inline String::~String()
{
	delete[] this->m_data;
}
inline String&
String::operator =(const String& s)
{
	if(this==&s)
		return *this;
	delete[] this->m_data;
	this->m_data = new char[strlen(s.m_data)+1];
	strcpy(this->m_data, s.get_c_str());
	return *this;
}	
inline int String::length() const
{
	return strlen(this->m_data);
}	
#endif
