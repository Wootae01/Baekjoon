import java.util.*;

class Solution {
    /**
        그냥 약수의 개수 구하는거 아닌가
        e 이하의 약수 개수 구하고
    */
    public int[] solution(int e, int[] starts) {
        int[] count = new int[e+1];
        
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <=e; j += i) {
                count[j]++;
            }
        }
        
        int[] best = new int[e+2];
        int max = 0;
        int maxIdx = 0;
        for (int i = e; i >= 1; i--) {
            if (count[i] >= max) {
                max = count[i];
                maxIdx = i;
            }
            best[i] = maxIdx;
        }
        
        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = best[starts[i]];
        }
        return answer;
    }
}