import java.util.*;

class Solution {
    /**
        그냥 stack인가
        보조 컨테이너는 스택 사용하고
    */
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack =  new Stack<>();
        
        int tmp = 0;
        for (int i = 0; i < order.length; i++) {
            int o = order[i];
            while(tmp < o) {
                stack.push(++tmp);
            }
            
            if (!stack.isEmpty()) {
                if (tmp == o) {
                    stack.pop();
                    answer++;        
                } else if (tmp > o) {
                    if (stack.peek() == o) {
                        stack.pop();
                        answer++;
                    } else {
                        break;
                    }
                }
            }
            
            
            
        }
        
        
        return answer;
    }
}