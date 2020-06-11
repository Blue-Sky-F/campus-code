#include<stdio.h>
#include<malloc.h>
#include<string.h>
#include<stdbool.h>
#include<unistd.h>
typedef struct PCB{
    int work_id;//进程ID
    char name[20];//进程名
    int level;//进程等级
    int submit_time_h;//提交时间/时
    int submit_time_m;//提交时间/分
    int run_time;//运行时间
    int space;//所占空间
}PCB;

typedef struct Node{
	PCB *data;
	struct Node *next;
}Node;

typedef struct Node *List;

//初始化PCB
PCB * generate_pcb(int work_id,char name[],int level,int submit_time_h,int submit_time_m,int run_time,int space){
	PCB *p = (PCB*)malloc(sizeof(PCB));
	p->work_id = work_id;
	strcpy(p->name,name);
	//p->name = name;//不合法的赋值
	p->level = level;
	p->submit_time_h = submit_time_h;
	p->submit_time_m = submit_time_m;
	p->run_time = run_time;
	p->space = space;
	return p;
}
//初始化Node
Node * generate_node(PCB * pcb){
	Node *node = (Node*)malloc(sizeof(Node));
	node->data = pcb;
	node->next = NULL;
	return node;
}
//设置剩余运行时间
void set_rest_run_time(PCB *pcb, int rest){
	pcb->run_time -= rest;
}
//打印一个PCB的信息
void print_pcb(PCB *node){
	printf("进程ID %d 进程名称 %s 进程等级 %d 提交时间 %d:%d 运行时间 %dms 空间占用 %dKB\n"
			,node->work_id,node->name,node->level,node->submit_time_h,node->submit_time_m
			,node->run_time,node->space);
}  
//将一个节点添加到链表尾部
void insert_pcb(PCB *pcb, List *list){
	Node *current = *list;
	Node *node = (Node*)malloc(sizeof(Node));
	node->data = pcb;
	if(current==NULL){
		*list = node;
	}
	else{
		while(current->next!=NULL)
			current = current->next;
		current->next = node;
	}
}
//将一个节点添加到链表尾部
void insert_node(Node *node, List *list){
	Node *current = *list;
	if(current==NULL)
		*list = node;
	else{
		while(current->next!=NULL)
			current = current->next;
		current->next = node;
	}
}	
bool is_exist(Node *node, List *list){
	Node *current = *list;
	while(current!=NULL){
		if(current->data->work_id == node->data->work_id)
			return true;
		current = current->next;
	}
	return false;
}
//链表是否为空
bool is_empty(List *list){
	Node *current = *list;
	if(current==NULL)
		return true;
	return false;
}	
//删除一个节点
bool delete_node(Node *node, List *list){
	Node *current = *list;
	if(current->data->work_id == node->data->work_id){
		*list = current->next;
		free(current);
		return true;
	}
	while(current->next!=NULL){
		if(current->next->data->work_id == node->data->work_id){
			Node *tem = current->next->next;
			free(current->next);
			current->next = tem;
			return true;
		}
		current = current->next;
	}
	return false;
}		
			
