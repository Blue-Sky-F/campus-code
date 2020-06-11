#include"list.c"
typedef struct Queue{
	int time_piece;
	List * list;
}Queue;
//设置时间片
void set_time_piece(Queue *queues, int time1, int time2, int time3){
	queues[0].time_piece = 0;
	queues[1].time_piece = time1;
	queues[2].time_piece = time2;
	queues[3].time_piece = time3;
}
//判断所有进程是否执行完毕
bool has_finished(Queue *queues){
	for(int i=0; i<4; i++)
		if(!is_empty(queues[i].list))
			return false;
	return true;
}
//判断等待队列是否为空
bool no_waiting_process(Queue *queues){
	for(int i=1; i<4; i++)
		if(!is_empty(queues[i].list))
			return false;
	return true;
}
//获取优先级最高的节点
Node* find_current_node(Queue *queues){
	for(int i=1; i<4; i++)
		if(!is_empty(queues[i].list))
			return *(queues[i].list);
	return NULL;
}
//获取当前队列的时间片大小
int get_current_time_piece(Queue *queues){
	for(int i=1; i<4; i++)
		if(!is_empty(queues[i].list))
			return queues[i].time_piece;
	return -1;
}
//获取当前进程在几号队列
int get_current_position(Queue *queues){
	for(int i=1; i<4; i++)
		if(!is_empty(queues[i].list))
			return i;
	return -1;
}		
Node* new_comer(Queue *queue,int current_time,int time_piece){
	if(*(queue->list)==NULL)
		return NULL;
	int submit_time_h = (*(queue->list))->data->submit_time_h;
	int submit_time_m = (*(queue->list))->data->submit_time_m;
	int submit_time = 60*submit_time_h+submit_time_m;
	if(submit_time<current_time+time_piece)
		return (*(queue->list));
	return NULL;
}
//将一个节点从队头插到队尾
void insert_from_head_to_rear(List *list){
	List *head = list;
	Node *current = *head;
	if(current!=NULL && current->next!=NULL){
		Node *tem = current;
		*head = current->next;
		tem->next = NULL;
		insert_node(tem,list);
	}
}
//当前进程执行完毕，移除队列
void remove_current_process(Queue *queues){
	int position = get_current_position(queues);
	List *head = queues[position].list;
	Node *current = *head;
	if(current->next!=NULL)
		*head = current->next;
	else
		*head = NULL;
	if(current!=NULL)
		free(current);
}
//将一个节点插到下一队列队尾
void insert_to_next_queue(Queue *queues, int position){
	if(position==3)
		insert_from_head_to_rear(queues[3].list);
	else{
		if(position>=0 && position<3){
			List *head = queues[position].list;
			Node *current = *head;
			if(current!=NULL){
				*head = current->next;
				current->next = NULL;
				insert_node(current,queues[position+1].list);
			}
		}
	}
}
			
void multi_wheel_schedualing(Queue *queues){
	int current_time = 0;
	while(true){
		if(has_finished(queues))//所有进程执行完毕
			break;
		if(no_waiting_process(queues)){//等待队列为空
			int submit_time = (*(queues->list))->data->submit_time_h*60+(*(queues->list))->data->submit_time_m;
			current_time += submit_time;
			insert_to_next_queue(queues,0);//将第一个进程装入等待队列
			continue;
		}
		Node *current_process = find_current_node(queues);
		int current_time_piece = get_current_time_piece(queues);
		int run_time = current_process->data->run_time;
		int current_position = get_current_position(queues);
		Node *new_process = new_comer(queues,current_time,current_time_piece);
		if(new_process!=NULL){
			int submit_time = new_process->data->submit_time_h*60+new_process->data->submit_time_m;
			int current_level = current_process->data->level;
			int newer_level = new_process->data->level;
			if(submit_time<current_time+run_time && newer_level>current_level){//发生进程抢占
				int runtime = submit_time-current_time;
				current_process->data->run_time -= runtime;
				current_time += runtime;
				int hour = current_time/60;
				int minite = current_time%60;
				int length = strlen(new_process->data->name);
				char blank[10-length];
				for(int j=0; j<(9-length); j++)
					blank[j] = ' ';
				blank[9-length] = '\0';
				printf("Name为%s%sID为%d的进程在%d:%d时刻，发生抢占...\n",new_process->data->name,blank,new_process->data->work_id,hour,minite);
				insert_to_next_queue(queues,0);//将抢占的进程插入第一队列
				insert_from_head_to_rear(queues[current_position].list);//将进程插入到队列尾部
				continue;
			}
			insert_to_next_queue(queues,0);	
		}
		if(run_time<current_time_piece){
			current_time += run_time;
			int current_time_h = current_time/60;
			int current_time_m = current_time%60;
			int length = strlen(current_process->data->name);
			char blank[10-length];
			for(int j=0; j<(9-length); j++)
				blank[j] = ' ';
			blank[9-length] = '\0';
			printf("进程号为%d\t进程名为%s%s 的进程于 %d:%d 时刻结束!\n",current_process->data->work_id,current_process->data->name,blank,current_time_h,current_time_m);
			remove_current_process(queues);//进程结束，移出队列并释放
			continue;
		}
		else{
			current_time += current_time_piece;
			current_process->data->run_time -= current_time_piece;
			insert_to_next_queue(queues,current_position);
			continue;
		}		
	}
	printf("进程调度结束...\n");	
}
//打印各进程信息
void print_condition(Queue *queues){
	for(int i=0; i<4; i++){
		printf("第%d队列的进程状态为:\n",i);
		Node *node = *(queues[i].list);
		while(node!=NULL){
			printf("%d %s %d\n",node->data->work_id,node->data->name,node->data->run_time);
			node = node->next;
		}
	}
}
void main(){
	Queue queues[4];//队列数组
	Node* head1 = NULL;
	queues[0].list = &head1; //载入队列
	Node* head2 = NULL;
	queues[1].list = &head2; //队列1
	Node* head3 = NULL;
	queues[2].list = &head3; // 队列2
	Node* head4 = NULL;
	queues[3].list = &head4; // 队列3
	//设置各队列的时间片长度
	set_time_piece(queues, 5,10,100);
	/* 将目标进程装入载入队列  */
	PCB *pcb1 = generate_pcb(110,"Alice",1,00,00,2,100);
	PCB *pcb2 = generate_pcb(111,"Bob",2,00,00,30,100);
	PCB *pcb3 = generate_pcb(112,"Green",3,00,00,200,100);
	PCB *pcb4 = generate_pcb(113,"Kobe",4,00,00,12,100);
	PCB *pcb5 = generate_pcb(114,"John",7,00,40,150,100);
	PCB *pcb6 = generate_pcb(115,"Karry",6,00,00,2,100);
	insert_pcb(pcb1,queues[0].list);
	insert_pcb(pcb2,queues[0].list);
	insert_pcb(pcb3,queues[0].list);
	insert_pcb(pcb4,queues[0].list);
	insert_pcb(pcb5,queues[0].list);
	insert_pcb(pcb6,queues[0].list);
	
	/**insert_to_next_queue(queues,0);
	insert_to_next_queue(queues,0);
	insert_to_next_queue(queues,0);
	insert_to_next_queue(queues,1);
	insert_to_next_queue(queues,2);
	insert_to_next_queue(queues,3);
	insert_to_next_queue(queues,1);
	insert_to_next_queue(queues,1);
	insert_from_head_to_rear(queues[0].list);
	insert_from_head_to_rear(queues[1].list);
	insert_from_head_to_rear(queues[2].list);
	insert_from_head_to_rear(queues[3].list);
	print_condition(queues);*/

	multi_wheel_schedualing(queues);
	//print_condition(queues);

}
