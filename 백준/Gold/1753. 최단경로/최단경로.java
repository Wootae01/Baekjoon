import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V, E;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        List<Node>[] list = new ArrayList[V+1];


        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        //다익스트라
        boolean[] visit = new boolean[V + 1];
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));
        dist[K] = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int cv = current.vertex;
            if (!visit[cv]) {
                visit[cv] = true;
                for (Node node : list[cv]) {
                    int nv = node.vertex;
                    if(dist[nv] > dist[cv] + node.weight){
                        dist[nv] = dist[cv] + node.weight;
                        queue.offer(new Node(nv, dist[nv]));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            }
            else{
                sb.append(dist[i] + "\n");
            }
        }
        System.out.println(sb);


    }
    static class Node implements Comparable<Node>{
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}