import java.util.*;

class Solution {
    /**
        음 그냥 하면 될거 같은데 반복문 돌려서 
    */
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> kind = new HashSet<>(Arrays.asList(gems));
        int kindSize = kind.size();
        
        Map<String, Integer> map = new HashMap<>();
        
        int start = 0;
        int end = 0;
        int s = 0; // 시작 값 결과 저장
        int e = 1000000000; 
       
        for (int i = 0; i < gems.length; i++) {
            String gem = gems[i];
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            
            while(map.size() == kindSize) {
                if (e - s > end - start) {
                    e = end;
                    s = start;
                }
                String current = gems[start++];
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0) {
                    map.remove(current);
                }
            }
            
            end++;
            
        }
        
        
        answer[0] = s+1;
        answer[1] = e+1;
        
        return answer;
    }
}