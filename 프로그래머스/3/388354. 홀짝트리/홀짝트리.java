import java.util.*;

class Solution {
    /**
        모든 노드에 대해 그래프 탐색을 한다...
        그럼 v(v+e) 시간 초과긴 한데..
        
        음 일단 연결 리스트 사용해서 그래프 만들면 
        각 노드별로 자식 노드 개수는 알 수 있네
        
        아 노드가 1부터 있는게 아니네 mapㅇ로 인덱싱을 해놓자.
    */
    public int[] solution(int[] nodes, int[][] edges) {
        int n = nodes.length;
        int[] answer = new int[2]; // [oddEvenRoots, reverseRoots]

        // value -> index
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) map.put(nodes[i], i);

        // 인접리스트
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // 간선 추가 (입력에 nodes에 없는 값이 있으면 무시)
        for (int[] e : edges) {
            Integer a = map.get(e[0]);
            Integer b = map.get(e[1]);
            // 무방향 그래프
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            // 컴포넌트 수집 (BFS)
            Queue<Integer> q = new ArrayDeque<>();
            List<Integer> comp = new ArrayList<>();
            q.offer(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                int u = q.poll();
                comp.add(u);
                for (int v : graph.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                    }
                }
            }

            // 컴포넌트 내에서 degree와 node값 parity 비교
            int eqCount = 0;   // node%2 == degree%2 인 노드 수
            int neqCount = 0;  // node%2 != degree%2 인 노드 수
            for (int idx : comp) {
                int valParity = nodes[idx] % 2;
                int degParity = (graph.get(idx).size()) % 2;
                if (valParity == degParity) eqCount++;
                else neqCount++;
            }

 
            if (eqCount == 1) answer[0]++;     
            if (neqCount == 1) answer[1]++; 
        }

        return answer;
    }
}