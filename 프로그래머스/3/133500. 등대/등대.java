import java.util.*;

class Solution {
    /**
        리프 노드의 부모 노드에 등대가 켜져있어야됨
    */
    
    List<List<Integer>> graph;
    int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        
        // 그래프 만들고
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < lighthouse.length; i++) {
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dp = new int[n + 1][2];
        
        dfs(1, 0);  // 1번을 루트로
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    void dfs(int current, int prev) {
        dp[current][0] = 0;  // current 안 켠 경우
        dp[current][1] = 1;  // current 켠 경우
        
        for (int next : graph.get(current)) {
            if (next == prev) continue;  // 방금 온 곳으로 되돌아가지 않기
            
            dfs(next, current);
            
            // current 안 켜면 next는 반드시 켜야됨
            dp[current][0] += dp[next][1];
            
            // current 켜면 next는 켜도 되고 안 켜도 됨
            dp[current][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}