import java.util.*;

class Solution {
    /**
     
        dp인가
        어떤 순서대로 열었는지를 저장해야되나?
        야 근데 dp면 감염된 어디에 감염되었는지 알아야되는거 아닌가
        
        음 그래프를 만들어야되나
        그것보단 어떤 통로가 열려있는지가 중요한거 아닌가
        type 별로 묶으면 좋을거 같은데 edges를
        
        a, b, c 각각 연결된 노드를 구하고
        
        아 완전탐색 같은데 n 값 범위가 
        아 되네 k값이 중요하네
        3 * 2^9 
        
    */
    private static int max = 0;
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;
        
        Map<Integer, List<int[]>> map = new HashMap<>(); // 타입 별 노드
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int type = edges[i][2];
            map.computeIfAbsent(type, t -> new ArrayList<>()).add(new int[]{x, y});
        }
        
        boolean[] infections = new boolean[n+1];
        infections[infection] = true;
        
        dfs(map, infections, -1, k, 0);    
        
        
        return max;
    }
    private void dfs(Map<Integer, List<int[]>> map, boolean[] infections, int prevType, int k, int depth) {
        if (k == depth) {
            int tmp = 0;
            for (int i = 0; i < infections.length; i++) {
                if (infections[i]) tmp++;
            }
            max = Math.max(max, tmp);
            return;
        }
       
        for (int i = 1; i <= 3; i++) {
            if (prevType == i) continue;
            boolean[] copy = infections.clone();
            List<int[]> pipes = map.getOrDefault(i, new ArrayList<>());
            
            boolean changed = true;
            // 감염 시키는거고
            while(changed) {
                changed = false;
                for (int[] arr : pipes) {
                    int x = arr[0];
                    int y = arr[1];
                    if (copy[x] && !copy[y]) { copy[y] = true; changed = true; }
                    if (copy[y] && !copy[x]) { copy[x] = true; changed = true; }
                }    
            }
            
            dfs(map, copy, i, k, depth+1);
            
        }
    }

}