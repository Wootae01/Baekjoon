/**
    2명 이상 주문한 조합, 
    코스는 2ㅐㄱ 이상 단품메뉴 조합
    
    
    와 어렵겠는데..?
    단품 메뉴 개수도 있네..?
    아 가장 많이 함께 주문된 조합이구나 
    
    모든 조합을 다 계산해야되나?
    시간복잡도가 될거 같네 
    
    조합 뽑아서 map에 저장해서 count 한다
    
*/
import java.util.*;
class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = new String[course.length];
        List<String> list = new ArrayList<>();
        
        for (int j = 0; j < course.length; j++) {
            map = new HashMap<>();
            
            for (int i = 0; i < orders.length; i++) {
                char[] arr = orders[i].toCharArray();
                Arrays.sort(arr);
                
                dfs(new String(arr), 0, course[j], "");
            }
            
            int max = 0;

            for (int value : map.values()) {
                max = Math.max(max, value);
            }

            if (max >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == max) {
                        list.add(key);
                    }
                }
            }
        }
        Collections.sort(list);
            
        return list.toArray(new String[0]);
    }
    
    private void dfs(String order, int start, int count, String result) {
        // 조합 완성된 경우
        if (result.length() == count) {
            int v = map.getOrDefault(result, 0);
            map.put(result, v+1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) { 
            char c = order.charAt(i);
            dfs(order, i+1, count, result+c);
                
        }
    }
    
    
}