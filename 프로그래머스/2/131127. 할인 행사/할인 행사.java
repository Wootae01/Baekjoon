import java.util.*;

class Solution {
    /*
        
        매번 확인을 해야되나 맞는지? 이게 좀 애매하네 
        시간복잡돈느 안넘게 그냥 ㄱ하자
        
    */
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int start = 0;
        int end = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        Map<String, Integer> currentMap = new HashMap<>();
        
        int i = 0;
        while (end < discount.length) {
           
            if (end - start < 10) {
                String s = discount[end];
                currentMap.put(s, currentMap.getOrDefault(s, 0) + 1);
                end++;
            } else {
                if (wantMap.equals(currentMap)) {
                    answer++;
                }
                String s = discount[start];
                int count = currentMap.get(s) - 1;

                if (count == 0) {
                    currentMap.remove(s);
                } else {
                    currentMap.put(s, count);
                }
                
                start++;
            }
        }
        if (wantMap.equals(currentMap)) {
            answer++;
        }
        
        
        return answer;
    }
}