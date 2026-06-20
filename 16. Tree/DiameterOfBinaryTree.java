import java.util.*;

import javax.swing.tree.TreeNode;

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
public class DiameterOfBinaryTree {
    int mx = 0; //global max variable

    // modified findheight fn with mx var
    private int findheight(Node root){
        if(root == null) return 0;

        int lh = findheight(root.left);
        int rh = findheight(root.right);

        mx = Math.max(lh+rh, mx);

        return (1 + Math.max(lh, rh));
    }

    public int diameterOfBinaryTree(Node root) {
        findheight(root);
        return mx;
    }

    public static void main(String[] args) {
        /* Example tree:
                 1
                / \
               2   3
              / \     
             4   5
        Diameter is number of edges on longest path (4-2-1-3) = 3 btw in diameter not mandatory to include root 
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        System.out.println(sol.diameterOfBinaryTree(root));
    }
}
