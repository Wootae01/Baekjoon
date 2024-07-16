import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int E;
    static List<MyNode>[] graph;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        //그래프 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[n1].add(new MyNode(n2, w));
            graph[n2].add(new MyNode(n1, w));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());


        //1. (1 ~ v1까지 최단거리) + (v1 ~ v2 최단 거리) + (v2 ~ N까지 최단 거리)
        //2. (1 ~ v2까지 최단거리) + (v1, v2 연결한 비용) + (v1 ~ N까지 최단 거리)
        int res1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int res2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        if (res1 >= 99999999 && res2 >= 99999999) {
            System.out.println(-1);
        }else{
            System.out.println(res1 < res2 ? res1 : res2);
        }

    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 99999999);
        boolean[] visit = new boolean[N + 1];
        Queue<MyNode> pq = new PriorityQueue<>();

        pq.offer(new MyNode(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            MyNode current = pq.poll();
            int cv = current.vertex;
            int w = current.weight;

            if (cv == end) {
                break;
            }

            visit[cv] = true;
            for (MyNode next : graph[cv]) {
                if (!visit[next.vertex] && w + next.weight < dist[next.vertex]) {
                    dist[next.vertex] = w + next.weight;
                    pq.offer(new MyNode(next.vertex, dist[next.vertex]));
                }
            }
        }
        return dist[end];
    }

    static class MyNode implements Comparable<MyNode>{
        int vertex;
        int weight;

        MyNode(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(MyNode o) {
            return this.weight - o.weight;
        }
    }

}
