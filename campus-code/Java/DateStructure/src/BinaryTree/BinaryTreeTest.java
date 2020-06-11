package BinaryTree;
/**
 * ≤‚ ‘∂˛≤Ê ˜
 * @author –Ï“Ì∑…
 *
 */
public class BinaryTreeTest {
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		Node<String> root = new Node();
		String node[] ={"a","b"," "," ","c"," "," "};
		tree.createBiTree(root, node, 0);
//		System.out.println(root.data);
//		System.out.println(root.left.data);
//		System.out.println(root.right.data);
//		System.out.println(tree.counter);
		tree.preTravel(root);
		System.out.println();
		
		tree.midTravel(root);
		System.out.println();
		
		tree.posTravel(root);
		System.out.println();
		
//		Node<Integer> noda =new Node();
//		noda.data = 2;
//
//		tree.insertBST(noda, 1);
//		tree.insertBST(noda, 5);
//		tree.insertBST(noda, 8);
//		tree.insertBST(noda, 4);
//		tree.insertBST(noda, 10);
//		tree.preTravel(noda);
//		System.out.println();
//		
//		System.out.println(tree.findMin(noda));
//		System.out.println(tree.findMax(noda));
//		System.out.println("\n"+tree.maxLength(noda));
//		System.out.println("\n"+tree.maxLength(root));
//		System.out.println("\n"+tree.minLength(noda));
//		System.out.println("\n"+tree.minLength(root));
		
		
		
		
	}

}
