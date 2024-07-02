
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        //거리 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, time));
        }

        //1. 노드 X에서 각 시작 정점까지 얼마나 걸리는지
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int k = 1; k <= N; k++) {

            boolean[] visit = new boolean[N + 1];

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(k, 0));

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int v = current.vertex;
                if (visit[v]) {
                    continue;
                }
                visit[v] = true;
                for (Node node : list[v]) {
                    if (!visit[node.vertex]) {
                        if (dist[k][node.vertex] > dist[k][v] + node.time) {
                            dist[k][node.vertex] = dist[k][v] + node.time;
                            pq.offer(new Node(node.vertex, dist[k][node.vertex]));
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i][X] + dist[X][i] > max) {
                max = dist[i][X] + dist[X][i];
            }
        }
        System.out.println(max);
    }

    static class Node implements Comparable<Node>{
        int vertex;
        int time;

        Node(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}