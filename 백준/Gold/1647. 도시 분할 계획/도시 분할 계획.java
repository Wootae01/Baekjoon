import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
        }

        //최소 스패닝 트리. 크루스칼
        int[] parent = new int[N + 1];
        Arrays.fill(parent, -1);

        int count = 0;
        int res = 0;
        while (count < N -2) {
            Node node = pq.poll();
            int s1 = find(node.vertex1, parent);
            int s2 = find(node.vertex2, parent);
            if (s1 != s2) {
                set_union(s1, s2, parent);
                res += node.weight;
                count++;
            }
        }
        System.out.println(res);
    }

    static int find(int vertex, int[] parent) {
        if (parent[vertex] < 0) {
            return vertex;
        }
        return parent[vertex] = find(parent[vertex], parent);
    }

    static void set_union(int s1, int s2, int[] parent) {
        int r1 = find(s1, parent);
        int r2 = find(s2, parent);
        parent[r1] = r2;
    }

    static class Node implements Comparable<Node>{
        int vertex1;
        int vertex2;
        int weight;

        public Node(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}