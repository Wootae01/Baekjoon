import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        /**
            무적권을 언제 사용하냐가 중요하겠네
            흠.. 무적권을 언제 사용해되지...?
            순서대로 더하다가 n 값을 넘어서면 무적권 사용. <- 가장 많은 enemy 였던 라운드에
            맥스 값도 같이 계산하다가 빼면 다음 맥스 값은 어떻게 계산함? 그 큐에 넣어놓아야 겟네
        */
        int answer = 0;
        
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
            sum += enemy[i];
            pq.add(enemy[i]);
            
            // 병사 수보다 더 많아지면
            if (sum > n) {
                if (k <= 0) break;
                while (!pq.isEmpty() && k > 0 && sum > n) {
                    int tmp = pq.poll();
                    sum -= tmp;
                    k--;
                }    
                answer++;
            } else {
                answer++;
            }
            
        }
        
        return answer;
    }
}