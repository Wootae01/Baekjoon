import java.util.*;

/**
    가장 낮은 음식의 스코빌 지수를 2개 찾고 계속 넣어야된다..?
    그래서 heap이구나
    
*/
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        
        while(!pq.isEmpty() && pq.peek() < K) {
            int first = pq.poll(); 
            
            if (pq.isEmpty()) return -1;
            
            int second = pq.poll();
            
            int n = first + second * 2;
            
            pq.offer(n);
            answer++;
        }
        
        return answer;
    }
}