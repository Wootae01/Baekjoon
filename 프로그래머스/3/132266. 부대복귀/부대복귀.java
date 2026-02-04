import java.util.*;

class Solution {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        // 인접 리스트 초기화
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i=1; i<=n; i++) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }
        
        // bfs
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(destination, 0);
        queue.add(start);
        boolean[] check = new boolean[n + 1];

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int v = cur.v;
            if (check[v]) continue;
            check[v] = true;
            dist[v] = Math.min(cur.w, dist[v]);
            
            for (int i = 0; i < graph[v].size(); i++) {
                int nv = graph[v].get(i);
                Node next = new Node(nv, cur.w + 1);
                queue.add(next);
            }
        }    
        
        // 정답
        for (int i = 0; i < sources.length; i++) {
            if (dist[sources[i]] == Integer.MAX_VALUE) {
                answer[i] = -1;
            } else {
                answer[i] = dist[sources[i]];    
            }
            
        }
        
        return answer;
    }
    static class Node {
        int v;
        int w;
        Node (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
   
    
}