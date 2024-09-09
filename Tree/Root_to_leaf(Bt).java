import java.util.*;

public class Main {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(Scanner scn) {
        if (!scn.hasNext()) {
            return null;
        }

        int data = scn.nextInt();
        Node root = new Node(data);

        boolean hasLeft = scn.nextBoolean();
        if (hasLeft) {
            root.left = buildTree(scn);
        }

        boolean hasRight = scn.nextBoolean();
        if (hasRight) {
            root.right = buildTree(scn);
        }

        return root;
    }

    public static void findPaths(Node root, int k, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }

        path.add(root.data);
        sum += root.data;

        if (root.left == null && root.right == null && sum == k) {
            for(int i=0;i<path.size();i++){
				System.out.print(path.get(i)+" ");
			}
			System.out.println();
        } else {
            findPaths(root.left, k, path, sum);
            findPaths(root.right, k, path, sum);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        Node root = buildTree(scn);

        int k = scn.nextInt();

        findPaths(root, k, new ArrayList<>(), 0);
    }
}

