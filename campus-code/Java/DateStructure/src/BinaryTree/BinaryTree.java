package BinaryTree;
import java.math.*;
/**
 * ��װ�����������ݽṹ
 * @author �����
 *
 */
public class BinaryTree {
	static int counter = 0;
	//����������
    public static Node createBiTree(Node root, String[] a, int i) {
	        if (i < a.length) {
	            if (a[i].equals(" ")) {
	                root = null;
	            } else {
	                Node<String> lchild = new Node();
	                Node<String> rchild = new Node();
	                root.data = a[i];
	                root.left = createBiTree(lchild, a, ++counter);
	                root.right = createBiTree(rchild, a, ++counter);
	            }
	        }
	        return root;
	    }
    //�������
    public static void preTravel(Node root){
    	if(root!=null){
    		System.out.print(root.data+"\t");
    		preTravel(root.left);
    		preTravel(root.right);
    	}
    }
    //�������
    public static void midTravel(Node root){
    	if(root!=null){
    		midTravel(root.left);
    		System.out.print(root.data+"\t");
    		midTravel(root.right);
    	}
    }
    //�������
    public static void posTravel(Node root){
    	if(root!=null){
    		posTravel(root.left);
    		posTravel(root.right);
    		System.out.print(root.data+"\t");
    	}
    }
    //��������������
    public Node insertBST(Node root ,int x){
    	if(root==null){
    		root =new Node();
    		root.data = x;
    		root.left=root.right=null;
    	}
    	else{
    		if(x<(Integer)root.data){
    			root.left = insertBST(root.left,x);
    		}
    		else if(x>(Integer)root.data){
    			root.right = insertBST(root.right,x);
    		}
    	}
    	return root;
    }
    //������
    public int maxLength(Node root){
    	if(root==null){
    		return 0;
    	}
    	else{
    		int left = maxLength(root.left);
    		int right = maxLength(root.right);
    		return(Math.max(left, right))+1;
    	
    	}
    }
    //��С���
    public int minLength(Node root){
    	if(root==null){
    		return 0;
    	}
    	else{
    		int left = minLength(root.left);
    		int right = minLength(root.right);
    		return Math.min(left, right)+1;
    	}
    }
    //������Сֵ����������£�
    public Object findMin(Node root){
    	while(root.left!=null){
    		root = root.left;
    	}
    	return root.data;
    }
    //�������ֵ����������£�
    public Object findMax(Node root){
    	while(root.right!=null){
    		root = root.right;
    	}
    	return root.data;
    }


}
