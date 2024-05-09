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
    static int res = -1;
    static boolean[] check;
    static int tmp;
    static int[] value;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        check = new boolean[n+1];
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
            check[i] = true;
            value = new int[2];
            dfs(i, 0, 0);
            if (value[0] + value[1] > res) {
                res = value[0] + value[1];
            }
            check[i] = false;
        }
        System.out.println(res);
    }

    static void dfs(int root, int sum, int depth) {
        ArrayList<Node> nodes = graph.get(root);

        //리프 노드이면
        if (nodes.size() <= 1) {
            if (sum > tmp) {
                tmp = sum;
            }

        }

        for (int i = 0; i < nodes.size(); i++) {
            int num = nodes.get(i).num;
            int weight = nodes.get(i).weight;
            if(!check[num]) {
                check[num] = true;
                dfs(num, sum + weight, depth+1);
                check[num] = false;
            }
            if (depth == 0) {
                if (tmp > value[0]) {
                    if (tmp > value[1]) {
                        value[0] = value[1];
                        value[1] = tmp;
                    }else{
                        value[0] = tmp;
                    }
                }
                tmp = 0;
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