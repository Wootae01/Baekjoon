import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Tree tree = new Tree();
        while (true) {
            String tmp = br.readLine();
            if (tmp == null || tmp.equals("")) {
                break;
            }
            int n = Integer.parseInt(tmp);
            tree.addNode(n);
        }
        tree.postOrder(tree.root);
    }

}

class Node{

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Tree{
    Node root;

    public void addNode(int val) {
        if (root == null) {
            root = new Node(val);
        }else{
            addNodeRef(root, val);
        }
    }
    private Node addNodeRef(Node current, int val) {
        if (current == null) {
            return new Node(val);
        }

        if (val < current.val) {
            current.left = addNodeRef(current.left, val);
        } else{
            current.right = addNodeRef(current.right, val);
        }
        return current;
    }

    public void postOrder(Node current) {
        if (current == null) {
            return;
        }
        postOrder(current.left);
        postOrder(current.right);
        System.out.println(current.val);
    }
}

