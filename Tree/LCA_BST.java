import java.util.*;
class Node {
	int val;
	Node left , right;
	Node(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}

}



public class Main {
	public static Node insert(Node root , int val){
		if(root==null){
			return new Node(val);
		}
		if(val<root.val){
			root.left = insert(root.left,val);
		}
		else{
			root.right = insert(root.right,val);
		}
		return root;
	}
	public static Node find(Node root , int p , int q){
		if(root==null){
			return null;
		}
		if(p<root.val && q<root.val){
			return find(root.left,p,q);
		}
		else if(p>root.val && q>root.val){
			return find(root.right,p,q);
		}
		else{
			return root;
		}
	}
 public static void main (String args[]) {
	 Scanner sc=new Scanner(System.in);

	    int n = sc.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            root = insert(root, k);
        }
       
        int p = sc.nextInt();
        int q = sc.nextInt();
       
       
       
        Node lca = find(root, p, q);
        if (lca != null) {
            System.out.println(lca.val);
        }
    }
}
