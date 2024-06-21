import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //입력
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Node>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        //다익스트라
        for (int i = 1; i <= n; i++) {

            int[] dist = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                dist[j] = Integer.MAX_VALUE;
            }

            boolean[] visit = new boolean[n + 1];
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));
            dist[i] = 0;

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int cv = current.vertex;
                if (visit[cv]) {
                    continue;
                }

                visit[cv] = true;
                for (Node node : list[cv]) {
                    if (!visit[node.vertex]) {
                        if (dist[node.vertex] > dist[cv] + node.weight) {
                            dist[node.vertex] = dist[cv] + node.weight;
                            pq.offer(new Node(node.vertex, dist[node.vertex]));
                        }
                    }
                }

            }

            for (int j = 1; j <= n; j++) {
                if (dist[j] == Integer.MAX_VALUE) {
                    sb.append("0 ");
                }
                else {
                    sb.append(dist[j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node>{
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.weight = weight;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}