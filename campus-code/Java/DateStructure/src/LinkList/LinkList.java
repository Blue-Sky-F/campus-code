package LinkList;
/**
 * ��װ����������ݽṹ
 * @author �����
 *
 */
public class LinkList {
	Node first;//ͷ���

	public LinkList(){
		this.first = null;
	}
	//ͷ��������½��
	public void insert(String data){
		Node node = new Node(data);
		node.next = first;
		first = node; 
	}
	//ͷ����ɾ�����
	public Node delete(){
		Node temp;
		temp = first;
		first = temp.next;
		return temp;
	}
	//����������
	public void travel(){
		while(first!=null){
			System.out.println(first.element);
			first = first.next;
		}
	}
	
	
	
	

}
