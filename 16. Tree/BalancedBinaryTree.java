import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

// Balanced Binary Tree : every node of tree have abs(leftHeight - rightHeight) >= 1

public class BalancedBinaryTree{
    // to find height from each node
    private int findheight(Node root){
        if(root == null) return 0;

        int l = findheight(root.left);
        int r = findheight(root.right);

        return (1 + Math.max(l, r));
    }

    public boolean isBalanced(Node root){
        if(root == null) return true;

        int lh = findheight(root.left);
        int rh = findheight(root.right);

        if(Math.abs(lh - rh) > 1) return false;

        // check for other nodes
        boolean left = isBalanced(root.left); 
        boolean right = isBalanced(root.right);
        
        //if any node have > 1 height diff return false
        if(!left || !right) return false;

        return true;
    }

    public static void main(String[] args) {
        BalancedBinaryTree ob = new BalancedBinaryTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Tree is balanced: " + ob.isBalanced(root));
    }
} 