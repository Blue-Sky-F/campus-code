#include"list.c"

//先来先服务算法
void fcfs(List *list){
	Node *current = *list;
	int hour = 0;
	int minite = 0;
	while(current!=NULL){
		int run_time = current->data->run_time;
		printf("当前运行进程:%s ID:%d 提交时间%d:%d  正在运行...\n",current->data->name
		,current->data->work_id,current->data->submit_time_h,current->data->submit_time_m);
		sleep(run_time);
		hour+=(minite+run_time)/60;
		minite=(minite+run_time)%60;
		printf("进程:%s 于%d:%d时刻结束运行\n\n",current->data->name,hour,minite);
		Node * dead = current;//执行完毕，从就绪列表中移除
		current = current->next;
		delete_node(dead,list);
	}
	printf("全部进程执行完毕!\n");
	
}

				

int main(){
	List *list ; //*list指向链表头部
	Node* head = NULL ;
	list = &head; 
	PCB *pcb1 = generate_pcb(110,"Alice",1,00,00,2,100);
	PCB *pcb2 = generate_pcb(111,"Bob",2,00,00,3,100);
	PCB *pcb3 = generate_pcb(112,"Green",2,00,00,2,100);
	PCB *pcb4 = generate_pcb(113,"Kobe",2,00,00,1,100);
	PCB *pcb5 = generate_pcb(114,"John",2,00,00,1,100);
	PCB *pcb6 = generate_pcb(115,"Karry",2,00,00,2,100);
	insert_pcb(pcb1,list);
	insert_pcb(pcb2,list);
	insert_pcb(pcb3,list);
	insert_pcb(pcb4,list);
	insert_pcb(pcb5,list);
	insert_pcb(pcb6,list);
	fcfs(list);
    return 1;
	
}
				
