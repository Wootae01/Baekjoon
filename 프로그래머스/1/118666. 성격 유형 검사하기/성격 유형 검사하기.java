/**
    아 문제 왜이리 길어
    R, T
    C, F
    J, M
    A, N
    
    단순히 그냥 map으로 count 하면 되겠네 이건 
*/
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            int score = choices[i];
            char key = score < 4 ? survey[i].charAt(0) : survey[i].charAt(1);
            
            if (score >= 4) {
                score = score - 4;
            } else {
                score = 4 - score;
            }
            int value = map.getOrDefault(key, 0) + score;
            map.put(key, value);
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(getType(map, 'R', 'T'));
        sb.append(getType(map, 'C', 'F'));
        sb.append(getType(map, 'J', 'M'));
        sb.append(getType(map, 'A', 'N'));
        
        return sb.toString();
    }
    private char getType(Map<Character, Integer> map, char a, char b) {
        if (map.getOrDefault(a, 0) >= map.getOrDefault(b, 0)) {
            return a;
        } else {
            return b;
        }
    }
}