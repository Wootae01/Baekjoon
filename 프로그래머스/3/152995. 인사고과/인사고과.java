import java.util.*;

class Solution {
        /**
            인센티브 x 사원 찾기 <- 이걸 어떻게 찾냐
            하나씩 찾아야되는거 아닌가 n^2 나오는데 그러면 근데 
            정렬을 해도 되나 ?
            [3,2] [3,2] [2,1] [2,2] [1,4]
            첫번째거 기준으로 정렬하고 2번째꺼만 본다.. 두번째거 큰 숫자를 유지시킨다..
            그리고 탈락시킴
            탈락은 어떻게 시킴? 
        */
    public int solution(int[][] scores) {
        int answer = 0;
        int onehoA = scores[0][0];
        int onehoB = scores[0][1];
        
       Arrays.sort(scores, (x, y) -> {
        if (x[0] != y[0]) return y[0] - x[0];
        return x[1] - y[1];
        });
        
        List<Integer> hap = new ArrayList<>(); // 합
        
        int maxB = -1;
        for (int i = 0; i < scores.length; i++) {
            
            if (maxB <= scores[i][1]) {
                maxB = scores[i][1];
                hap.add(scores[i][0] + scores[i][1]);
            } else {
                // 원호 탈락한 경우
                if (scores[i][0] == onehoA && scores[i][1] == onehoB) return -1;
            }
            
        }
        
        // 석차 계산
        int oneho = onehoA + onehoB;
        for(int n : hap) {
            if (n > oneho) answer++;
        }
        return answer + 1;
    }
}