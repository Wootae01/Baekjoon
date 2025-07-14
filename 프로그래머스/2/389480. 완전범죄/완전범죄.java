import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 121;
        int answer = INF;
        int r = info.length;
        int c = m;
        
        int[][] dp = new int[r][c];
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                dp[i][j] = INF;
                if(i == 0 && j == 0) {
                    dp[i][j] = info[0][0];
                } else if(i == 0 && j == info[i][1]) {
                    dp[i][j] = 0;
                }
                
            }
        }
        
        
        
        
        for(int i = 1; i < r; i++){
            for(int j = 0; j < c; j++){
                
                int tmp = j - info[i][1];
                if(tmp < 0){
                    dp[i][j] = dp[i-1][j] + info[i][0];
                } else {
                    dp[i][j] = Math.min(dp[i-1][tmp], dp[i-1][j] + info[i][0]);    
                }
                
            }
        }
        
        for(int j = 0; j < c; j++){
            if(dp[r-1][j] >= n) continue;
            answer = Math.min(dp[r-1][j], answer);
        }
        if(answer >= INF) answer = -1;
        return answer;
    }
}