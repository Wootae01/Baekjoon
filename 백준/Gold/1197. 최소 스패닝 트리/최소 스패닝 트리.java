import java.io.*;
import java.util.*;

class Main{
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> heap = new PriorityQueue<>();

        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            heap.offer(new Node(u, v, weight));
        }

        int n = 0;
        int res = 0;
        parent = new int[V+1];
        for (int i = 0; i < V; i++) {
            parent[i] = -1;
        }

        while (n < V - 1) {
            Node node = heap.poll();
            int s1 = find(node.u);
            int s2 = find(node.v);
            if (s1 != s2) {
                union(node.u, node.v);
                n++;
                res += node.weight;
            }
        }
        System.out.println(res);
    }

    static int find(int vertex) {
        if (parent[vertex] == -1) {
            return vertex;
        }
        return parent[vertex] = find(parent[vertex]);
    }

    static void union(int v1, int v2) {
        int s1 = find(v1);
        int s2 = find(v2);
        parent[s1] = s2;
    }
}

class Node implements Comparable<Node>{
    int u;
    int v;
    int weight;
    Node(int u, int v, int weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}