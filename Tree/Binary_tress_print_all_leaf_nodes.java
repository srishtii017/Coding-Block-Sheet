import java.util.*;

public class Main {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
		// Main m = new Main();
        BinaryTree bt = new BinaryTree();
        bt.buildTree();
        List<Integer> l = bt.getLeafNodes();
        for(int e:l){
			System.out.print(e+" ");
		}                   
    }

    private static class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
            
            Node(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        private Node root;

        public void buildTree() {
            Queue<Node> queue = new LinkedList<>();
            root = new Node(scn.nextInt());
            queue.add(root);
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                int leftData = scn.nextInt();
                int rightData = scn.nextInt();
                if (leftData != -1) {
                    current.left = new Node(leftData);
                    queue.add(current.left);
                }
                if (rightData != -1) {
                    current.right = new Node(rightData);
                    queue.add(current.right);
                }
            }
        }

        public List<Integer> getLeafNodes() {
            List<Integer> l = new ArrayList<>();
            coll(root, l);
            return l;
        }

        private void coll(Node node, List<Integer> l) {
            if (node == null) return;

            if (node.left == null && node.right == null) {
                l.add(node.data);
            }

            coll(node.left, l);
            coll(node.right, l);
        }
    }
}
