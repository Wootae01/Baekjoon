/**
    일단 입력이 100이하이다.
    그래프? 구성 하고 
    흠 하나씩 다 끊어 봐야되나
    
*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        List<List<Integer>> graph  = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        answer = 100;
        for (int i = 0; i < wires.length; i++) {
            int count = bfs(wires[i][0], n, graph, wires[i][0], wires[i][1]);
            int tmp = Math.abs(count-n+count);
            answer = Math.min(answer, tmp);
        }
       
        
        return answer;
    }
    private int bfs(int start, int n, List<List<Integer>> graph, int skipA, int skipB) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        queue.add(start);
    
        int count = 1;
    
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if ((cur == skipA && next == skipB) || (cur == skipB && next == skipA))
                    continue;
    
                if (visited[next]) continue;
                
                visited[next]  = true;
                count++;
                queue.add(next);
            }
        } 
        return count;
    }
}