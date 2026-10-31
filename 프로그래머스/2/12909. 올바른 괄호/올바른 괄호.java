import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(c);
                continue;
            } 
            // 닫힌 괄호인 경우
            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            return false;
            
        }
        
        // 스택에 괄호가 남아 있으면
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}