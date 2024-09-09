import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);
	private static HashMap<Integer , Integer> map = new HashMap<>();

	public static void main(String[] args) {
		
		int[] pre = takeInput();
		int[] in = takeInput();
		BinaryTree bt = new Main().new BinaryTree(pre, in);
		bt.display();
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
			Node(int data){
				this.data = data;
				this.left =null;
				this.right = null;
			}
		}

		private Node root;
		private int preorderIndex;

		public BinaryTree(int[] pre, int[] in) {
			map.clear();
			for(int i=0;i<in.length;i++){
				map.put(in[i],i);
			}
			preorderIndex=0;
			this.root = construct(pre, 0, in.length - 1);
		}

		private Node construct(int[] pre, int inorderStart , int inorderEnd) {

			// write your code here
            if(inorderStart>inorderEnd){
				return null;
			}
			int rootVal = pre[preorderIndex++];
			Node root =new Node(rootVal);
			int rootIndex = map.get(rootVal);
			root.left = construct(pre,inorderStart,rootIndex-1);
			root.right = construct(pre,rootIndex+1,inorderEnd);
			return root;
            
        }

      
		

		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String str = "";

			if (node.left != null) {
				str += node.left.data;
			} else {
				str += "END";
			}

			str += " => " + node.data + " <= ";

			if (node.right != null) {
				str += node.right.data;
			} else {
				str += "END";
			}

			System.out.println(str);

			this.display(node.left);
			this.display(node.right);
		}

	}

}

