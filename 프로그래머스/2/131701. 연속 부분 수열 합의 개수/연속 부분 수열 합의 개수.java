import java.util.*;

class Solution {
    /**
        그냥 조합 문제인가
        아 연속 부분수열이구나
        처음과 마지막만 좀 어떻게 연결시키는가인데
        1. 리스트에 값을 필요한 만큼 더 넣는다.
        2.
        
    */
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        
        Set<Integer> set = new HashSet<>();
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(elements[i]);
        }
        for (int i = 0; i < n; i++) {
            list.add(elements[i]);
        }
        
        for (int i = 1; i <= n; i++) {
            int start = 0;
            
            while (start < n) {
                int end = start + i;
                int sum = 0;
                for(int tmp = start; tmp < end; tmp++) {
                    sum += list.get(tmp);
                }
                set.add(sum);
                start++;
            }
        }
        
        return set.size();
    }
}