import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        BinaryTree bt = new BinaryTree(arr);
        bt.rightView(); 
    }
}

class BinaryTree {
    private class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    BinaryTree(String[] arr) {
        root = construct(arr);
    }

    private Node construct(String[] arr) {
        if (arr.length == 0 || arr[0].equals("-1")) return null;

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(arr[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            if (i < arr.length && !arr[i].equals("-1")) {
                current.left = new Node(Integer.parseInt(arr[i]));
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && !arr[i].equals("-1")) {
                current.right = new Node(Integer.parseInt(arr[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public void rightView() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i == size - 1) { 
                    System.out.print(node.data + " ");
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println();
    }
}

