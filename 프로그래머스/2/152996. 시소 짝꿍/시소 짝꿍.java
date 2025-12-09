import java.util.*;

class Solution {
    /**
        1:1, 1:2, 2:3, 3:4
    */
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        long[] freq = new long[1001];
        for (int i = 0; i < weights.length; i++) {
            freq[weights[i]]++;
        }
        
        for (int i = 100; i <= 1000; i++) {
          if (freq[i] > 0)   {
              
              answer += (freq[i] * (freq[i] - 1)) / 2;
              
              if (i * 2 <= 1000) {
                  answer += freq[i] * freq[i * 2];
              }
              
              if (i % 2 == 0 && i * 3 / 2 <= 1000) {
                  answer += freq[i] * freq[i * 3 / 2];
              }
              if (i % 3 == 0 && i * 4 / 3 <= 1000) {
                  answer += freq[i] * freq[i * 4 / 3];
              }
          }
            
        }
          
        return answer;
    }
}