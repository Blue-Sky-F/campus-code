#include<vector>
#include<cstdlib>
#include<time.h>
#include"template_sort.h"
// P-A; Q-2; A-10; B-J; C-Q; D-K; W-SML Z-LAR
class poker
{
public:
	poker(){}
	~poker(){}
	void shuffle();
	vector<vector<char>>& deal();
	void show_cards();
private:
	vector<char> d = {'P','P','P','P','Q','Q','Q','Q','3','3','3','3','4','4','4','4','5','5','5','5',
				'6','6','6','6','7','7','7','7','8','8','8','8','9','9','9','9','A','A','A','A',
				'B','B','B','B','C','C','C','C','D','D','D','D','W','Z'};
	vector<char> base;
};
inline void poker::shuffle()
{	srand(time(0));
	int size = d.size();
	for(int i=0; i<2000; ++i){
		int a = rand()%size;
		int b = rand()%size;
		char t = d[a];
		d[a] = d[b];
		d[b] = t;		
	}
}

inline vector<vector<char>>& poker::deal()
{
	vector<vector<char>> *card = new vector<vector<char>>();
	vector<vector<char>>& cards = *card;
	cards.resize(3);
	int k=0;
	for(int i=0; i<3; ++i)
		for(int j=0; j<17; ++j)
			cards[i].push_back(d[k++]);
	while(k<d.size())
		base.push_back(d[k++]);
	for(int i=0; i<3; ++i)
		quick_sort(cards[i]);
	return cards;
}
inline void poker::show_cards()
{
	this->shuffle(); 
	const vector<vector<char>>& cards = deal();
	for(int i=0; i<cards.size(); ++i){
		cout<<"  玩家"<<i+1<<":"<<"  ";
		for(int j=0; j<cards[i].size(); ++j){
			switch(cards[i][j]){
				case 'P': cout<<'A';break;
				case 'Q': cout<<'2';break;
				case 'A': cout<<"10"<<" ";break;
				case 'B': cout<<'J';break;
				case 'C': cout<<'Q';break;
				case 'D': cout<<'K';break;
				case 'W': cout<<"小王";break;
				case 'Z': cout<<"大王";break;
				default : cout<<cards[i][j];
			}
		}	
		cout<<endl;
	}
	cout<<"  底牌"<<":  "<<"\t";
	for(char e: base)
		switch(e){
			case 'P': cout<<'A'<<' ';break;
			case 'Q': cout<<'2'<<' ';break;
			case 'A': cout<<"10"<<" ";break;
			case 'B': cout<<'J'<<' ';break;
			case 'C': cout<<'Q'<<' ';break;
			case 'D': cout<<'K'<<' ';break;
			case 'W': cout<<"小王"<<' ';break;
			case 'Z': cout<<"大王"<<' ';break;
			default : cout<<e<<' ';
		}
	cout<<endl<<"  叫地主......"; 
}

