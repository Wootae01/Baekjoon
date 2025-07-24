import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        /**
            1. 생성한 정점을 찾아야됨.
            2. 각 그래프가 존재하는지 찾아야됨 <- 그래프 탐색
            
            3. 생성한 정점은 어떻게 찾음?? 해당 간선으로 들어오는게 없으면 됨
            4. 다음은 어떻게 그래프를 찾는가 인데.... dfs인가 bfs인가 
                1) 도넛은 정점 n개 간선 n개
                2) 막대는 정점 n개 간선 n-1개
                3) 8자는 정점 2n+1 간선 2n+2
            5. 시작 정점을 찾고 그냥 정점의 개수랑 간선 개수 찾으면 될거 같은데..?
        */
        int[] answer = {0,0,0,0};
        int length = edges.length;
        
        //1.루트노드, 가장 큰 노드 값 구하기
        Set<Integer> in = new HashSet<>();
        Set<Integer> out = new HashSet<>();
        Set<Integer> all = new HashSet<>();
        
        for(int i = 0 ; i< length; i++){
            in.add(edges[i][1]);
            out.add(edges[i][0]);
            all.add(edges[i][0]);
            all.add(edges[i][1]);
        }
        
        //가장 큰 노드 값
        int n = Collections.max(all);
        
        Set<Integer> candidates = new HashSet<>(out);
        candidates.removeAll(in); //루트 노드 후보
        
        //3. 그래프 만들기
        List<Integer>[] graph = new LinkedList[n + 1];
        for(int i = 0; i < n + 1; i++) { 
            graph[i] = new LinkedList<>();
        }
        for(int i = 0; i < length; i++){
            graph[edges[i][0]].add(edges[i][1]);
        }
        
        //루트 노드 찾기
        int root = -1, maxDeg = -1;
        for (int c : candidates) {
            int deg = graph[c].size();
            if (deg > maxDeg) {
                maxDeg = deg;
                root = c;
            }
        }
        answer[0] = root;
        
        
        //4. dfs 
        for(int i = 0 ; i < graph[root].size(); i++){
            int nodeCount = 0;
            int edgeCount = 0;
            boolean[] check = new boolean[n+1];
            Stack<Integer> stack = new Stack<>();
            
            int node = graph[root].get(i);
            stack.push(node);
            check[node] = true;
            while(!stack.isEmpty()) {
                int a = stack.pop();
                nodeCount++;
                edgeCount += graph[a].size();
                
                for(int j = 0; j < graph[a].size(); j++) {
                    int b = graph[a].get(j);
                    if(check[b]) continue;
                    
                    check[b] = true;
                    stack.push(b);
                }
            }
            if(nodeCount == edgeCount){ //도넛
                answer[1]++;
            } else if(nodeCount - 1 == edgeCount){ //막대
                answer[2]++;
            } else if(nodeCount == edgeCount - 1){ //8자
                answer[3]++;
            }
        }
        
        return answer;
    }
    
}