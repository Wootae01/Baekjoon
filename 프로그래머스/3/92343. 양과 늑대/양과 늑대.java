import java.util.*;

class Solution {
    /**
        음
        일단 그래프부터 만들고 
        bfs인가 높이별로 개수 구해놓고 아 애매한디
        dfs인가 
        
        
        
        
    */
    static int maxSheep = -1;
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        List<List<Integer>>  graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        List<Integer> nextList = new ArrayList<>();
        nextList.add(0);
        dfs(graph, info, 0, 0, 0, nextList);
            
        
        return maxSheep;
    }
    
    private static void dfs(List<List<Integer>> graph, int[] info, int current,
                            int sheep, int wolf, List<Integer> nextList) {
        
        if (info[current] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        
        if (wolf >= sheep) return;
        maxSheep = Math.max(maxSheep, sheep);
        
        List<Integer> newList = new ArrayList<>(nextList);
        newList.remove(Integer.valueOf(current));
        
        for (int n : graph.get(current)) {
            newList.add(n);
        }
        
        for (int n : newList) {
            dfs(graph, info, n, sheep, wolf, newList);
        }
        
    }
    
}