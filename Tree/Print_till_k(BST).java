import java.util.Scanner;

public class Main {
    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public Main() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void add(int data) {
        this.root = this.add(data, this.root);
    }

    private Node add(int data, Node node) {
        if (node == null) {
            this.size++;
            return new Node(data, null, null);
        }
        if (data > node.data) {
            node.right = add(data, node.right);
        } else if (data < node.data) {
            node.left = add(data, node.left);
        }
        return node;
    }

    public void remove(int data) {
        this.root = this.remove(this.root, data);
    }

    private Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = this.remove(node.left, data);
        } else if (data > node.data) {
            node.right = this.remove(node.right, data);
        } else {
            if (node.left == null) {
                this.size--;
                return node.right;
            } else if (node.right == null) {
                this.size--;
                return node.left;
            } else {
                int lmax = this.max(node.left);
                node.data = lmax;
                node.left = this.remove(node.left, lmax);
            }
        }
        return node;
    }

    private int max(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        if (node == null) return;
        if (node.left != null) {
            System.out.print(node.left.data + " => ");
        } else {
            System.out.print("END => ");
        }
        System.out.print(node.data);
        if (node.right != null) {
            System.out.print(" <= " + node.right.data);
        } else {
            System.out.print(" <= END");
        }
        System.out.println();
        display(node.left);
        display(node.right);
    }

    public void printKFar(int tar, int k) {
        this.printKFar(this.root, tar, k);
    }

    private int printKFar(Node node, int tar, int k) {
        if (node == null) {
            return -1;
        }
        if (node.data == tar) {
            printKDown(node, k);
            return 0;
        }
        int ldist = printKFar(node.left, tar, k);
        if (ldist != -1) {
            if (ldist + 1 == k) {
                System.out.println(node.data);
            } else {
                printKDown(node.right, k - ldist - 2);
            }
            return ldist + 1;
        }
        int rdist = printKFar(node.right, tar, k);
        if (rdist != -1) {
            if (rdist + 1 == k) {
                System.out.println(node.data);
            } else {
                printKDown(node.left, k - rdist - 2);
            }
            return rdist + 1;
        }
        return -1;
    }

    private void printKDown(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
            return;
        }
        printKDown(node.left, k - 1);
        printKDown(node.right, k - 1);
    }

    public static void main(String[] args) {
        Main bst = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            bst.add(s.nextInt());
        }
        int tar = s.nextInt();
        int k = s.nextInt();
        bst.printKFar(tar, k);
        s.close();
    }
}

