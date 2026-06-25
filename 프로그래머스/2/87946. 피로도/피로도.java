/**
    음 행이 8개? 그럼 반복문 돌리면 되나
    최대 던전 수를 알아야된다..?
    일단 완전탐색인거 같고 던전 3개만 선택하면 되니까 순서 고려 안하고
    백트래킹으로 하면 
    
*/
class Solution {
    public static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] select = new boolean[n];
        
        back(dungeons.length, dungeons, select, k, 0);
        return max;
    }
    
    void back(int n, int[][] dungeons, boolean[] select, int k, int count) {
        
        for (int i = 0; i < n; i++) {
            if (select[i]) continue;
            
            if (dungeons[i][0] <= k) { // 최소 피로도 <= 현재 피로도
                k -= dungeons[i][1];
                select[i] = true;
                back(n, dungeons, select, k, count+1);
                select[i] = false;
                k += dungeons[i][1];
            } 
            
        }
        max = Math.max(max, count);
        
    }
    
}