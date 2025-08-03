import java.util.*;

class Solution {
    /**
        곡괭이 부서질때까지 사용함. 광물 5개 캘 수 있음.
        피로도 최소값
        
        그냥 이거는 모든 경우의 수 다 찾아야될 거 같은데 흠 어떻게?
        곡괭이의 순서만 정하면 됨. ㅇㅇ 순열인거 같네
    */
    
    // 피로도 계산을 위한 값
    static Map<String, Integer> map = Map.of(
        "diamond", 3,
        "iron", 2,
        "stone", 1
    );
    
    public int solution(int[] picks, String[] minerals) {
        
        int answer = 0;
        int count = 0;
        for (int i = 0 ; i < picks.length; i++) {
            count += picks[i];
        }
        
        // 모든 곡괭이 1차원 배열로
        String[] pickax = new String[count];
        int tmp = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < picks[i]; j++) {
                if(i == 0) {
                    pickax[tmp++] = "diamond";        
                }
                else if(i == 1) {
                        pickax[tmp++] = "iron";        
                }
                else if(i == 2) {
                        pickax[tmp++] = "stone";        
                }
            } 
        }
        
        int[] res = new int[1];
        res[0] = 1500;
        boolean[] check = new boolean[count]; // 현재 사용 가능한 곡괭이
        int segments = (minerals.length + 4) / 5;
        boolean[][] check2 = new boolean[segments][3]; // 같은 종류의 곡괭이 사용 여부
        recursive(pickax, minerals, check, check2, 0, res, 0);
            
        answer = res[0];
        return answer;
    }
    private static void recursive (String[] pickax, String[] minerals, 
                                  boolean[] check, boolean[][] check2, int depth, int[] min, int cal) {
        
        if (depth >= minerals.length || !isUsablePick(check)) {
            min[0] = Math.min(min[0], cal);
            return;
        }
        
        int segIdx = depth / 5;
        for (int i = 0; i < pickax.length; i++) {
            int pickType = map.get(pickax[i]);
            if(check2[segIdx][pickType - 1] || check[i]) continue;
            check2[segIdx][pickType - 1] = true;
            
            int add = calculate(pickax[i], minerals, depth);
            check[i] = true;
            recursive(pickax, minerals, check, check2, depth + 5, min, cal + add);
            check[i] = false;
        }
        for (int i = 0; i < 3; i++) {
            check2[segIdx][i] = false;
        }
        
    }
    private static int calculate (String pickax, String[] minerals, int start) {
        int sum = 0;
        
        for (int i = start; i < start + 5 && i < minerals.length; i++) {
            int n = map.get(pickax) - map.get(minerals[i]);
            
            if(n >= 0) sum += 1;
            else if(n == -1) sum += 5;
            else if (n == -2) sum += 25;
            
        }
        
        return sum;
    }
    private static boolean isUsablePick(boolean[] check) {
        for (int i = 0; i < check.length; i++) {
            if(!check[i]) return true;
        }
        return false;
    }
}