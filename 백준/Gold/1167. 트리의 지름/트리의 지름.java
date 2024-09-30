import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static List<Node>[] graph;
    static int res = 0;
    static int far;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        graph = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                graph[n].add(new Node(v, w));
            }
        }
        boolean[] visit = new boolean[V + 1];
        dfs(1, visit, 0);

        Arrays.fill(visit, false);
        res = 0;
        dfs(far, visit, 0);

        System.out.println(res);
    }

    static void dfs(int v, boolean[] visit, int sum) {
        visit[v] = true;

        if (sum > res) {
            res = sum;
            far = v;
        }
        for (int i = 0; i < graph[v].size(); i++) {
            Node next = graph[v].get(i);
            if (!visit[next.v]) {
                visit[next.v] = true;
                dfs(next.v, visit, sum + next.w);
                visit[next.v] = false;
            }
        }
    }
    static class Node{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}