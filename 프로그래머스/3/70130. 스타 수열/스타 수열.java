import java.util.*;
class Solution {
    /**
        와 어렵네
        10만이니까 반복문은 1번만 돌려야되고
        
        교집합이 1 이상이어야된다 이게 핵심인건가
        부분 수열이 그냥 a에서 숫자 아무거나 빼도 되니까
        a에서 각 숫자 몇개씩있는지 count 하면 될거 같은데??
        
        가장 큰 값 구하고, 이거 개수보다 더 많으면 되나?
        아 연속해서 붙어있으면 안되네 샤뱔
        쌍이 존재하는지 확인한다?
        이게 시간 초과가 안나오나
        
    */
    public int solution(int[] a) {
        int answer = -1;
        Map<Integer, Integer> map = new HashMap<>();
       
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        
       for (int x : map.keySet()) {
           int pair = 0;
           int v = map.get(x);
           if (v*2 < answer) continue;
           for (int i = 0; i < a.length - 1; i++) {
               if ((a[i] == x || a[i+1] == x) && a[i] != a[i+1]) {
                   pair++;
                   i++;
               }
           }
           answer = Math.max(pair*2, answer);
       }
        
        
        
        
        return answer;
    }
}