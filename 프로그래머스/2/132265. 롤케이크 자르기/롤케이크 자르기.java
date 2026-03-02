import java.util.*;
class Solution {
    /**
        흠 뭐지
        일단 가장 단순한건 브루투포스로 모든 경우 돌리는건데
        시간 초과 나올거 같고
        
        각 토핑 개수 count 하고 하나씩 빼면 되려나
        토핑 몇종류인지 찾고 하면 되려나
        집합 사용하면 편할거 같긴하네
    */
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] count1 = new int[10001];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        
        for (int i = 0; i < topping.length; i++) {
            count1[topping[i]]++;
            set1.add(topping[i]);
        }
        
        for (int i = 0; i < topping.length; i++) {
            count1[topping[i]]--;
            set2.add(topping[i]);
            if (count1[topping[i]] == 0) {
                set1.remove(topping[i]);
            }
            
            if (set1.size() == set2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}