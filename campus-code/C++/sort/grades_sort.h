#include <iostream>
using namespace std;
template<class T> void sweap(T &a, T &b){
    T tem = a;
    a = b;
    b = tem;
}
typedef struct Student{
    string name;
    int grades;
    int compareTo(Student s){
        return this->grades>s.grades? 1: 0;
    }
     void init(string name, int grades){
        this->name = name;
        this->grades = grades;
    }
}Student;

template<class T> void pop_sort(T *s, int len){
    for(int i=0; i<len-1; i++){
        for(int j=len-1; j>i; j--){
            if(s[j].compareTo(s[j-1]))
                sweap<T>(s[j-1],s[j]);
        }
    }
}
template<class T> void pop_reverse_sort(T *s, int len){
    for(int i=0; i<len-1; i++){
        for(int j=len-1; j>i; j--){
            if(s[j-1].compareTo(s[j]))
                sweap<T>(s[j-1],s[j]);
        }
    }
}
template<class T> void show(T *s,int len){
    for(int i=0; i<len; i++){
        cout<< s[i].name <<"\t" << s[i].grades <<endl;
    }
}

