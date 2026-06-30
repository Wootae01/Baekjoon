/**
    이건 그냥 스택 문제인데?
    나중에 들어간 열린 괄호가 가장 먼저 나와야 되니까 ㅇㅇ
    아 문제를 안읽었엇네 
*/

import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        int len = s.length();
        for (int j = 0; j < len; j++) {
            Stack<Character> stack = new Stack<>();
            boolean b = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt((i+j) % len);
                int count = 0;
                if(c == '(' || c == '[' || c == '{') { // 열린 괄호 이면
                    stack.push(c);    
                } else { // 닫힌 괄호 이면
                    if(stack.size() == 0){
                        b = false;
                        break;
                    } 
                    char tmp = map.get(stack.peek());

                    if(tmp == c) {
                        
                        stack.pop();
                    }

                }
            }
            if(stack.size() == 0 && b) {
                answer++;
            }
        }
        return answer;
    }
}