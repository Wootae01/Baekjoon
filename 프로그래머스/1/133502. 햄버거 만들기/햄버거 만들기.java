/**
    음 그냥 포장하는 햄버거 개수를 구하는거네
    그러면 각각 재료 개수 count 하면 되겠네
    
    아 연속해서 재료 4개가 있어야되는구나 이걸 몰랐네;;
    그럼 그냥 스택 문제네 
    
*/
import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            int size = stack.size();
            if (
                size >= 4 &&
                stack.get(size - 4) == 1 &&
                stack.get(size - 3) == 2 &&
                stack.get(size - 2) == 3 &&
                stack.get(size - 1) == 1
              ) {
                for (int j = 0; j< 4; j++) {
                    stack.pop();
                }
                answer++;
            }
        }
        
        return answer;
    }
}