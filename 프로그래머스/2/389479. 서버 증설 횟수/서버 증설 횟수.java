import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int answer = 0;
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < players.length; i++){
            
            while(queue.size() > 0 && queue.peek() == i-k){
                queue.poll();
            }
            
            int required = players[i] / m ;
            if(queue.size() < required){
                int additional = required - queue.size();
                for(int j = 0; j < additional; j++){
                    queue.offer(i);    
                }
                answer += additional;
            }
        }
        
        return answer;
    }
}