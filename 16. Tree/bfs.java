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

public class bfs {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.add(root);

        while(!q.isEmpty()){
            ArrayList<Integer> lvl = new ArrayList<>();
            int size = q.size();

            for(int i = 0; i<size; i++){
                Node node = q.poll();
                lvl.add(node.data);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

            }
            ans.add(lvl);
        }
        return ans;
    }



    public static void main(String[] args) {
        bfs tree = new bfs();

        // Creating sample tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        List<List<Integer>> result = tree.levelOrder(root);

        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
