import java.util.*;

class Node{
    int data;
    Node right, left;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}

// traverse in anti-clockwise


public class BoundaryTraversal {

    private boolean isLeaf(Node root){
        if(root == null) return false;
        
        return (root.left == null && root.right == null);
    }

    public void LeftBoundary(Node root, ArrayList<Integer> ans){
        Node curr = root.left;

        while(curr != null){
            if(isLeaf(curr) == false) ans.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }

    }

    public void addLeaves(Node root, ArrayList<Integer> ans){ // pre-order
        if(isLeaf(root)) ans.add(root.data);

        if(root.left != null) addLeaves(root.left, ans);
        if(root.right != null) addLeaves(root.right, ans);
    }

    public void RightBoundary(Node root, ArrayList<Integer> ans){ //add in reverse order
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();

        while(curr != null){
            if(isLeaf(curr) == false) st.push(curr.data); 
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        while(!st.isEmpty()){  // add right eles in reverse order in ans
            ans.add(st.pop());
        }
    }

    public ArrayList<Integer> boundaryTraversal(Node root){ 
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        if(isLeaf(root) == false) ans.add(root.data); // * add root to ans then add L - leaves - R

        LeftBoundary(root, ans);
        addLeaves(root, ans);
        RightBoundary(root, ans);

        return ans;

    }
    

    public static void main(String[] args) {
        BoundaryTraversal ob = new BoundaryTraversal();

        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);

        ArrayList<Integer> ans = ob.boundaryTraversal(root); // [1, 4, 3, 2]

        System.out.println(ans);



    }
}
