import java.util.*;
/*
    그냥 브루투포스인거 같은데
    100개이니까 반복문 4개 돌려도 되네
**/
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int m = 0; m < targets.length; m++) {
            
            answer[m] = sum(keymap, targets, m);
        }
        
        
        return answer;
    }
    
    public int sum(String[] keymap, String[] targets, int m) {
        int sum = 0;
        for (int n = 0; n < targets[m].length(); n++) {
            int x = find(keymap, targets[m].charAt(n));
            if (x == -1) return -1;
            sum += x;
        }
        return sum;
    }
    
    public int find(String[] keymap, char target) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < keymap.length; i++) {
            String str = keymap[i];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == target) {
                    min = Math.min(j+1, min);
                }
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }
}