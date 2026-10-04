
/**
    각 스테이지마다 힌트권을 살지 말지 결정해야되는데
    dp인가? 아니다 
    그냥 브루트포스인가? n이 16이면 가능하네
    어떻게 구현하는가 브루트포스를..
    dfs인가 끝까지 가서 계산하고 다시 계산 하고,,
*/
import java.util.*;

class Solution {
    
    public static int res = Integer.MAX_VALUE;
    
    public int solution(int[][] cost, int[][] hint) {
        
        int answer = 0;
        int n = cost.length;
        int[] buy = new int[n];
        dfs(cost, hint, buy, n, 0, 0);
        return res;
    }
    
    
    public void dfs(int[][] cost, int[][] hint, int[] buy, int n, int i, int sum) {
        
        if (n == i) {
            res = Math.min(res, sum);
            return;
        }
        
        // 힌트 안 산 경우
        int tmp = sum + cost[i][buy[i]];
        dfs(cost, hint, buy, n, i + 1, tmp);
        
        if (i == n - 1) {
            return;
        }
        // 힌트 산 경우
        tmp = sum + hint[i][0];
        int[] tmpBuy = buy.clone();
        for (int j = 1; j < hint[i].length; j++) {
            int idx = hint[i][j] - 1;
            tmpBuy[idx] = Math.min(n - 1, tmpBuy[idx] + 1);
        }
        
        tmp += cost[i][buy[i]];
        dfs(cost, hint, tmpBuy, n, i + 1, tmp);
    }
    
    
}







