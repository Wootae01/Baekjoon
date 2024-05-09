import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 *
 *
 * */

public class Main {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int n;
    static int res = 0;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프 초기화
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(parent).add(new Node(child, weight));
            graph.get(child).add(new Node(parent, weight));
        }

        for (int i = 0; i < n; i++) {
            check = new boolean[n+1];
            check[i] = true;
            dfs(i, 0);

        }
        System.out.println(res);
    }

    static void dfs(int root, int sum) {
        ArrayList<Node> nodes = graph.get(root);
        res = Math.max(res, sum);

        for (int i = 0; i < nodes.size(); i++) {
            int num = nodes.get(i).num;
            int weight = nodes.get(i).weight;
            if (!check[num]) {
                check[num] = true;
                dfs(num, sum + weight);
            }
        }
    }
}

class Node{
    public int num, weight;
    Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }
}