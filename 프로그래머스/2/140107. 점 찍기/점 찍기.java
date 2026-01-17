import java.util.*;

class Solution {
    /**
        음..... 거리가 (ka)^2 + (kb)^2 <= d^2 을 만족하면 되는거 같은데
        
        2중 for문 돌리면 시간 초과가 나올거 같은데 
        
    */
    public long solution(int k, int d) {
        long answer = 0;
    
        long ds = 1L * d * d;
        long ks = 1L * k * k;
        double v = ds / ks;
        
        for (long a = 0; a*a <= v; a++) {
            double tmp = v - a*a;
            if (tmp != 0) {
                double b = Math.sqrt(tmp);    
                answer += (long)b;
            }
            
            answer += 1; // 0 포함
        }
        
        
        return answer;
    }
}