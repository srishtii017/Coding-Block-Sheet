import java.util.Scanner;  

class TreeNode {  
    int data;  
    TreeNode left, right;  

    TreeNode(int item) {  
        data = item;  
        left = right = null;  
    }  
}  

public class Main {  
    static int postIndex;  

    static int search(int[] inorder, int start, int end, int value) {  
        for (int i = start; i <= end; i++) {  
            if (inorder[i] == value) {  
                return i;  
            }  
        }  
        return -1;  
    }  

    static TreeNode buildTree(int[] postorder, int[] inorder, int inStart, int inEnd) {  
        if (inStart > inEnd) {  
            return null;  
        }  

        TreeNode node = new TreeNode(postorder[postIndex]);  
        postIndex--;  

        if (inStart == inEnd) {  
            return node;  
        }  

        int idx = search(inorder, inStart, inEnd, node.data);  

        node.right = buildTree(postorder, inorder, idx + 1, inEnd);  
        node.left = buildTree(postorder, inorder, inStart, idx - 1);  

        return node;  
    }  

    static void display(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        System.out.print((root.left == null ? "END" : root.left.data) + " => " + root.data + " <= " + (root.right == null ? "END" : root.right.data));  
        System.out.println();  
        display(root.left);  
        display(root.right);  
    }  

    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  

        int n = sc.nextInt();  
        int[] postorder = new int[n];  
        
        for (int i = 0; i < n; i++) {  
            postorder[i] = sc.nextInt();  
        }  
        
        int m = sc.nextInt();  
        int[] inorder = new int[m];  
        
        for (int i = 0; i < m; i++) {  
            inorder[i] = sc.nextInt();  
        }  

        postIndex = n - 1;  
        
        TreeNode root = buildTree(postorder, inorder, 0, n - 1);  
        
        display(root);  
        
    }  
}


