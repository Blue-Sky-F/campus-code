#include"complex.h"
#include"String.h"
#include"subject.h"
#include"multiset_test.h"
#include"vector_test.h"
#include"map_test.h"
#include"set_test.h"
#include"win_set.h"
#include"poker.h"
#include"demo.h"
#include<iterator>
#include<algorithm>

int main(){
	win_set(); 
/**----------complex_test-------------*/
//	complex<double> x(1,2.2);
//	++x;
//	//complex<double> u = x;//do not call for complex's construction function.
//	cout<<x<<x+1<<1+x<<x;
/**----------complex_test-------------*/

/**-----------string_test-------------*/
//	String* s1 = new String("hello");
//	String* s2 = new String("world");
//	cout<< s1->get_c_str() <<endl;
//	cout<< s2->get_c_str() <<endl;
//	char* a = s1->get_c_str();
//	char* b = s2->get_c_str();
//	cout<< static_cast<void*>(a)<<"\t"<<static_cast<void*>(b)<<endl;
//	String s  = *s1;
//	cout<<static_cast<void*>(s.get_c_str())<<"\t"<<static_cast<void*>(s1->get_c_str())<<endl; 
//	cout<<s.get_c_str()<<"\t"<<s1->get_c_str();
/**-----------string_test-------------*/

//	B b;//call for A's construction function before call for B's construction function 
//	B c;//complier transforms this sentence to "B b = B()". B() initialize a object while b is not a enterty, is a nickName. 

/**------------obsever_test------------*/
//observer* ob1 = new observer();
//observer* ob2 = new observerA();
//observer* ob3 = new observerB();
//subject sub;
//sub.attach(ob1);
//sub.attach(ob2);
//sub.attach(ob3);
//sub.set_value(8);
/**------------obsever_test------------*/

/**------------Container_test------------*/ 
//long size;
//cout <<"how many elements:";
//cin >> size;
//test_multiset(size);
//test_vector(size);
//test_set(size);
//test_map(size);
/**-----------Container_test-------------*/
//cout<<__cplusplus<<endl;

/**-------------poker_test---------*/
poker p;
p.show_cards();
/**-------------poker_test---------*/

/**------world_symmetrical_day_test---*/ 
//world_symmetrical_day();
/**------world_symmetrical_day_test---*/ 

}
