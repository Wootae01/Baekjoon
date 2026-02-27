import java.util.*;

class Solution {
    /**
        일단 target을 만드는게 우선
        1~20까지 숫자가 있고 2,4,8 ..... 40. 50
        3,6,9,12, .... ,54,57,60 까지
        같은 값이면 싱글을 맞추는게 좋음.
        
        흠.. 어렵네
        61 이면 50 + 11 이 best이고
        20까지는 싱글
        21 ~49는 <- 2개 던지거나 되는숫자 1개
        50은 불
        그럼 51 ~ 70까지는 이러네 50 + 20  불 + 싱글 or 3의 배수는 1개만 던지면 되네
        71~ 80 은 60 + 싱글
        
        80이 분기점인가 애매한데
        
        그냥 규칙이 없나 
        그럼 1부터 몇번 던지는지 계산하는건데
        2중 for문 나오지 않나
        
        싱글 불도 저장해야돼? 샤발
            
        
    */
    public int[] solution(int target) {
        int INF = Integer.MAX_VALUE / 4;
        
        // 초기화
        int[][] dp = new int[target + 1][2];
        for (int i = 0; i <= target; i++) {
            dp[i][0] = INF;
            dp[i][1] = 0;
        }
        
        // 다트 1번 던져서 가능한 점수들 1~20. 
        List<Integer> scores = new ArrayList<>();
        for (int i = 1; i <= 20 ; i++) {
            scores.add(i);
        }
        for (int i = 21; i <= 40; i++) {
            if (i % 2 == 0 || i % 3 == 0) {
                scores.add(i);
            }
        }
        for (int i = 41; i <= 60; i++) {
            if (i % 3 == 0) {
                scores.add(i);
            }
            if (i == 50) {
                scores.add(i);
            }
        }
        
        // dp
        dp[0][0] = 0;
        
        for (int i = 1; i <= target; i++) {
            for (int score : scores) {
                if (i < score) continue;
                
                int value = dp[i-score][0] + 1;
                int single = dp[i-score][1];
                
                if (score <= 20 || score == 50) {
                    single += 1;
                }
                
                if (dp[i][0] > value) {
                    dp[i][0] = value;
                    dp[i][1] = single;
                } else if (dp[i][0] == value && dp[i][1] < single) {
                    dp[i][1] = single;
                }
                
                
            }
        }
        int[] answer = {dp[target][0], dp[target][1]};
        return answer;
    }
}