import javax.print.attribute.IntegerSyntax;
import java.io.*;
import java.util.*;

class Main{
    static int N;
    static int M;
    static int K;
    static int[] candy;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N + 1]; // 각 아이가 가지고 있는 사탕 수
        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        //1. 아이들의 관계에 따른 사탕 개수 계산
        boolean[] visited = new boolean[N + 1];
        List<CandyAndChild> candyAndChildren = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            CandyAndChild candyAndChild = new CandyAndChild(1, candy[i]);
            dfs(i, candyAndChild, visited);
            candyAndChildren.add(candyAndChild);
        }

        //2. dp 계산
        int[][] dp = new int[candyAndChildren.size() + 1][K];
        for (int i = 1; i <= candyAndChildren.size(); i++) {
            CandyAndChild candyAndChild = candyAndChildren.get(i - 1);
            for (int j = 0; j < K; j++) {
                dp[i][j] = dp[i - 1][j];
                if(candyAndChild.getChild() > j) continue;
                int tmp = candyAndChild.getCandy() + dp[i - 1][j - candyAndChild.getChild()];
                dp[i][j] = Math.max(tmp, dp[i][j]);
            }
        }
        System.out.println(dp[candyAndChildren.size()][K - 1]);
    }

    static void dfs(int n, CandyAndChild candyChild, boolean[] visited) {
        visited[n] = true;
        for (int i = 0; i < graph[n].size(); i++) {
            int node = graph[n].get(i);
            if(visited[node]) continue;
            candyChild.setChild(candyChild.getChild() + 1);
            candyChild.setCandy(candyChild.getCandy() + candy[node]);
            dfs(node, candyChild, visited);
        }
    }
    static class CandyAndChild{
        private int child;
        private int candy;

        public CandyAndChild(int child, int candy) {
            this.candy = candy;
            this.child = child;
        }

        public int getCandy() {
            return this.candy;
        }

        public int getChild() {
            return this.child;
        }

        public void setCandy(int candy) {
            this.candy = candy;
        }

        public void setChild(int child) {
            this.child = child;
        }
    }
}