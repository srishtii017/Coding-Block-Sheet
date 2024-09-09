import java.util.*;

class Main {

    static class BST {
        public class Node {
            int data;
            Node left;
            Node right;

            Node(int data, Node left, Node right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }

        private Node root;
        private int size;

        public BST() {
            this.root = null;
            this.size = 0;
        }

        public void add(int data) {
            if (this.isEmpty()) {
                this.root = new Node(data, null, null);
                this.size++;
            } else {
                this.add(this.root, data);
            }
        }

        private void add(Node node, int data) {
            if (data > node.data) {
                if (node.right != null) {
                    this.add(node.right, data);
                } else {
                    this.size++;
                    node.right = new Node(data, null, null);
                }
            } else if (data < node.data) {
                if (node.left != null) {
                    this.add(node.left, data);
                } else {
                    this.size++;
                    node.left = new Node(data, null, null);
                }
            } else {
                // Node already exists, no need to add
            }
        }

        public boolean isEmpty() {
            return this.root == null;
        }

        public void display() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            return this.toString(this.root);
        }

        private String toString(Node node) {
            if (node == null) {
                return "";
            }

            String retVal = "";

            if (node.left != null) {
                retVal += node.left.data + " => ";
            } else {
                retVal += "END" + " => ";
            }

            retVal += node.data;

            if (node.right != null) {
                retVal += " <= " + node.right.data;
            } else {
                retVal += " <= " + "END";
            }

            retVal += "\n";

            retVal += this.toString(node.left);
            retVal += this.toString(node.right);

            return retVal;
        }
    }

    static int[] help(int arr[]) {
        int pre[] = new int[arr.length];
        pre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre[i] = arr[i] + pre[i - 1];
        }
        return pre;
    }

    // Modify function to accept BST.Node instead of just Node
    public static void modi(BST.Node nn, ArrayList<Integer> al) {
        if (nn == null) return;
        modi(nn.left, al);
        nn.data = al.get(0);
        al.remove(0);
        modi(nn.right, al);
    }

    public static void main(String[] args) {
        BST b1 = new BST();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // number of nodes
        int arr[] = new int[n];
        int q = 0;
        while (n-- > 0) {
            int m = scn.nextInt();
            arr[q++] = m;
            b1.add(m);
        }
        Arrays.sort(arr);
        int ans[] = help(arr);
        int sum = 0;

        for (int i : arr) sum += i;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i : ans) {
            al.add(sum - i);
        }
        modi(b1.root, al);
        b1.display(); 
    }
}
