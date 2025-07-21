import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> {
            if(a[1] != b[1]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int current = 0;
        for(int i = 0; i < targets.length; i++){
            if(targets[i][0] >= current) {
                current = targets[i][1];
                answer++;
            }
        }
            
        return answer;
    }
}