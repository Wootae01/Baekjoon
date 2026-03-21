import java.util.*;

class Solution {
    /**
        아 이게 다단계구나 
        
        1원 미만이면 분배 x
        
        자식 부모 맵 만들고
        그냥 반복문 돌려서 계산하면 되겠네
        
    */
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        
        // 인덱스 정보
        Map<String, Integer> info = new HashMap<>();
        for (int i  = 0; i < n; i++) {
            info.put(enroll[i], i);
        }
        
        // 자식, 부모
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(enroll[i], referral[i]);
        }
        
        int[] answer = new int[n];
        
        for (int i = 0; i < seller.length; i++) {
            int money = amount[i] * 100;
            String cur = seller[i];
            while(!cur.equals("-") && money > 0) {
                answer[info.get(cur)] += (money - money / 10);
                money = money / 10;
                cur = map.get(cur);
            }
        }
        return answer;
    }
}