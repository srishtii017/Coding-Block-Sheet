import java.util.*;

public class Main {

    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class BinarySearchTree {
        TreeNode root;

        // Convert inorder array to BST
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
        }

        private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
            if (start > end) return null;

            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBSTHelper(nums, start, mid - 1);
            node.right = sortedArrayToBSTHelper(nums, mid + 1, end);

            return node;
        }

        // Calculate and replace node values with the sum of all greater or equal nodes
        public void replaceWithGreaterSum() {
            this.totalSum = 0;
            replaceWithGreaterSumHelper(root);
        }

        private int totalSum;

        private void replaceWithGreaterSumHelper(TreeNode node) {
            if (node == null) return;

            // Traverse right subtree first (reverse inorder)
            replaceWithGreaterSumHelper(node.right);

            // Update node value
            totalSum += node.data;
            node.data = totalSum;

            // Traverse left subtree
            replaceWithGreaterSumHelper(node.left);
        }

        // Preorder traversal of the tree
        public void printPreorder() {
            printPreorderHelper(root);
            System.out.println();
        }

        private void printPreorderHelper(TreeNode node) {
            if (node == null) return;
            System.out.print(node.data + " ");
            printPreorderHelper(node.left);
            printPreorderHelper(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] inorderArray = new int[n];
        for (int i = 0; i < n; i++) {
            inorderArray[i] = scn.nextInt();
        }

        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.sortedArrayToBST(inorderArray);
        bst.replaceWithGreaterSum();
        bst.printPreorder();
    }
}

