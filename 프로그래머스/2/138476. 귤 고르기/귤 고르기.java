import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        /**
            음.. 당장 떠오르는건
            정렬해서 각가 크기 count한 맵 저장해놓고
            map 정렬해서 찾기? 이거네
        */
        int answer = 0;
        Arrays.sort(tangerine);
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            int key = tangerine[i];
            int value = map.getOrDefault(key, 0);
            map.put(key, value + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        int tmp = k;
        for (Map.Entry<Integer, Integer> e : entryList) {
            answer++;
            tmp = tmp - map.get(e.getKey());
            if (tmp <= 0) break;
        }   
        
        
        return answer;
    }
}