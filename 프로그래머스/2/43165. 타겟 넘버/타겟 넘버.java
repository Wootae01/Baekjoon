/**
    20개밖에 안되면 음 브루트포스인데
    모든 경우를 다 구한다 음 어떻게..?
    일단 +인지 -인지 결정해가면서 
    아 target 숫자를 만들어야되는구나
    아 뭐야 순서를 안바꾸네?
*/
import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for (int i = 0; i < numbers.length; i++) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                int c = queue.poll();
                queue.add(c + numbers[i]);
                queue.add(c - numbers[i]);
            }
        }
        while(!queue.isEmpty()) {
            int n = queue.poll();
            if(n == target) answer++;
        }
        return answer;
    }
}