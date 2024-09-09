import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt = m.new BinaryTree();
		bt.sibling();
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

		public void sibling() {
			this.sibling(this.root);
		}

		private void sibling(Node node) {
			if(node==null) return;
			Queue<Node> q = new LinkedList<>();
			q.add(node);
			while(!q.isEmpty()){
				int size = q.size();
				for(int i=0;i<size;i++){
					Node cur = q.poll();
					if(cur.left!=null){
						q.add(cur.left);
						if(cur.right==null){
							System.out.print(cur.left.data+" ");
						}
					}
					if(cur.right!=null){
						q.add(cur.right);
						if(cur.left==null){
							System.out.print(cur.right.data+" ");
						}
					}
				}
			}
		}

	}

}

