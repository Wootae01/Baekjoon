import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Node rootNode = new Node('A');

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            rootNode.addNode(rootNode, root, left, right);
        }

        rootNode.preOrder(rootNode);
        System.out.println();
        rootNode.inOrder(rootNode);
        System.out.println();
        rootNode.postOrder(rootNode);

    }
}

class Node{
    char val;
    Node left;
    Node right;


    Node(char val) {
        this.val = val;
        left = null;
        right = null;
    }

    public void addNode(Node current, char root, char left, char right){
        if (current.val == root) {
            current.left = (left == '.') ? null : new Node(left);
            current.right = (right == '.') ? null : new Node(right);
        } else{
            if(current.left != null) addNode(current.left, root, left, right);
            if(current.right != null)addNode(current.right, root, left, right);
        }
    }

    public void preOrder(Node current) {
        if(current == null) {
            return;
        }
        System.out.print(current.val);
        preOrder(current.left);
        preOrder(current.right);

    }

    public void inOrder(Node current) {
        if (current == null) {
            return;
        }
        inOrder(current.left);
        System.out.print(current.val);
        inOrder(current.right);
    }

    public void postOrder(Node current) {
        if (current == null) {
            return;
        }
        postOrder(current.left);
        postOrder(current.right);
        System.out.print(current.val);
    }
}

