package LinkList;
/**
 * 封装单链表的数据结构
 * @author 徐翼飞
 *
 */
public class LinkList {
	Node first;//头结点

	public LinkList(){
		this.first = null;
	}
	//头结点后插入新结点
	public void insert(String data){
		Node node = new Node(data);
		node.next = first;
		first = node; 
	}
	//头结点后删除结点
	public Node delete(){
		Node temp;
		temp = first;
		first = temp.next;
		return temp;
	}
	//遍历单链表
	public void travel(){
		while(first!=null){
			System.out.println(first.element);
			first = first.next;
		}
	}
	
	
	
	

}
