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
class Pair<T, U> {
    private T key; //node
    private U value; //num

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }
}
public class PreInPostTrav {
    // Function to get the Preorder,
    // Inorder and Postorder traversal
    // Of Binary Tree in One traversal
    public List<List<Integer>> preInPostTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Stack<Pair<Node, Integer>> st = new Stack<>();

        st.push(new Pair<>(root, 1));

        while (!st.isEmpty()) {
            Pair<Node, Integer> it = st.pop();

            //pre
            if(it.getValue() == 1){
                pre.add(it.getKey().data);

                it.setValue(2);
                st.push(it);
                if(it.getKey().left != null){
                    st.push(new Pair<>(it.getKey().left, 1));
                }
            }

            else if(it.getValue() == 2){
                in.add(it.getKey().data);

                it.setValue(3);
                st.push(it);
                if(it.getKey().left != null){
                    st.push(new Pair<>(it.getKey().left, 1));
                }
            }

            else{ //num == 3
                post.add(it.getKey().data);                
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;

    }

    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        // Creating tree
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        PreInPostTrav obj = new PreInPostTrav();

        List<List<Integer>> ans = obj.preInPostTraversal(root);

        List<Integer> pre = ans.get(0);
        List<Integer> in = ans.get(1);
        List<Integer> post = ans.get(2);

        System.out.print("Preorder: ");
        printList(pre);

        System.out.print("Inorder: ");
        printList(in);

        System.out.print("Postorder: ");
        printList(post);
    }
    
}
