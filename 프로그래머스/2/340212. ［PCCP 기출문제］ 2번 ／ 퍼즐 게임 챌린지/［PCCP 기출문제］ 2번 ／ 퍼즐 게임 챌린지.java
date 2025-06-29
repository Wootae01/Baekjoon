import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int max = -1;
        for(int i = 0; i < diffs.length; i++){
            max = diffs[i] > max ? diffs[i] : max;
        }
        
        int start = 1;
        int end = max;
        answer = max;
        while(start <= end){
            int level = (start + end) / 2;
            long time = cal(diffs, times, level);
            if(time > limit){
                start = level+1;
            } 
            else{
                answer = Math.min(answer, level);
                end = level - 1;
            }
        }
        
        
        return answer;
    }
    
    static long cal(int[] diffs, int[] times, int level){
        long time = 0L;
        
        for(int i = 0; i < times.length; i++){
            if(diffs[i] <= level){
                time += times[i];
            }
            else {
                int wrong = diffs[i] - level;
                if(i == 0){
                    time += wrong * times[i] + times[i];
                } 
                else{
                    time += wrong * (times[i-1] + times[i]) + times[i];    
                }
            }
            
        }
        return time;
    }
}