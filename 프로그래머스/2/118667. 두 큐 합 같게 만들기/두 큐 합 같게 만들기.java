import java.util.*;

class Solution {
    /**
        하 모르ㅔㄱㅆ네
        
    */
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        
        // 원소의 합 구하기
        long sum1 = 0;
        long sum2 = 0;
        for (int i  = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        long target = (sum1 + sum2) / 2;
        
        Queue<Integer> q1 = new LinkedList<>();
        for (int x : queue1) {
            q1.offer(x);
        }
        Queue<Integer> q2 = new LinkedList<>();
        for (int x : queue2) {
            q2.offer(x);
        }
      
        int limit = (q1.size() + q2.size()) * 3;
        while (limit >= answer) {
            if (sum1 > sum2 && !q1.isEmpty()) {
                int n = q1.poll();
                sum1 -= n;
                q2.offer(n);
                sum2 += n;
                
            } else if (sum2 > sum1 && !q2.isEmpty()) {
                int n = q2.poll();
                sum2 -= n;
                q1.offer(n);
                sum1 += n;
            } else {
                return answer;
            }
            answer++;
        }
        
        if (limit < answer) {
            return -1;
        }
        
        return answer;
    }
}