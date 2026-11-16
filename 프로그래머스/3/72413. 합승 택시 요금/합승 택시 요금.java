import java.util.*;
/**
    그냥  다익스트라 같은데
    아 근데 길이 겹치는 경우가 
    
    s -> x -> a, b 이렇게 나눈다고? 어렵네
    
*/
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        int[] distS = new int[n + 1];
        int[] distA = new int[n + 1];
        int[] distB = new int[n + 1];
        Arrays.fill(distS, Integer.MAX_VALUE);
        Arrays.fill(distA, Integer.MAX_VALUE);
        Arrays.fill(distB, Integer.MAX_VALUE);
        
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
             graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }   
        
        dijkstra(s, graph, distS);
        dijkstra(a, graph, distA);
        dijkstra(b, graph, distB);
        
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
        }
        
        return answer;
    }
    
    private void dijkstra(int s, List<List<Node>> graph, int[] dist) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.offer(new Node(s, 0));
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            
            for (Node next : graph.get(current.vertex)) {
                int nextVertex = next.vertex;
                int newCost = next.cost + current.cost;
                
                if (newCost < dist[nextVertex]) {
                    dist[nextVertex] = newCost;
                    pq.offer(new Node(nextVertex, newCost));
                }
                
            }
            
            
        }
    }
    
    private static class Node implements Comparable<Node>{ 
        int vertex;
        int cost;
        
        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}