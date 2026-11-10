import java.util.*;

/**
    그냥 그래프 탐색인데 
    bfs로 할까
*/
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] check = new boolean[n];
        
        
        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            Queue<Integer> queue = new LinkedList<>();    
            queue.offer(i);
            check[i] = true;
            
            while(!queue.isEmpty()) {
                int current = queue.poll();
                for (int j = 0; j < computers[current].length; j++) {
                    if  (computers[current][j] == 0) continue;
                    if (check[j]) continue;
                    
                    check[j] = true;
                    queue.offer(j);
                }
            }
            answer++;
        }        
        
        return answer;
    }
}