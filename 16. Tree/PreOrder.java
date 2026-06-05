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

public class PreOrder {

    public void preorderTraversal(Node root, List<Integer> arr) {
        if(root == null) return;

        arr.add(root.data);
        preorderTraversal(root.left, arr);
        preorderTraversal(root.right, arr);
    }


    public List<Integer> preorderTraversal(Node root){
        List<Integer> a = new ArrayList<>();
        preorderTraversal(root, a);
        return a;
    }

    public static void main(String[] args) {

        // Creating tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        PreOrder obj = new PreOrder();

        List<Integer> ans = obj.preorderTraversal(root);

        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
