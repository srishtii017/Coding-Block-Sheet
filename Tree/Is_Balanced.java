import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isBalanced());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

				public boolean isBalanced() {
			if(root==null) return true;
            return fun(root)!=-1;
		}

		private int fun(Node node) {
			// write your code here
            if(node==null) return 0;
            int l = fun(node.left);
            int r = fun(node.right);
            if(l==-1 || r==-1 || Math.abs(l-r)>1){
                return -1;
            }
			return Math.max(l,r)+1;
		}


	}
}

