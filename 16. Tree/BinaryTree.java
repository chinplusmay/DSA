import java.util.*;

class Node {
        Node left, right;
        int data;

        public Node(int key){
            this.data = key;
            left = right = null;
        }
    }

public class BinaryTree {
    Node root;
    
    // in order trav
    // void printInOrder(Node node) {
    //     if (node == null) return;
    //     printInOrder(node.left);       // 1. Visit Left
    //     System.out.print(node.data + " "); // 2. Print Root
    //     printInOrder(node.right);      // 3. Visit Right
    // }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        // tree.printInOrder(tree.root);
    }
}
