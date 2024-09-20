import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        List<Node>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, length));
            graph[b].add(new Node(a, length));
        }
        //입력 종료

        int res = -1;
        for (int start = 1; start <= n; start++) {
            //다익스트라
            int[] distance = new int[n + 1];
            Arrays.fill(distance, INF);
            boolean[] visited = new boolean[n + 1];

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(start, 0));
            distance[start] = 0;

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                visited[start] = true;
                for (int i = 0; i < graph[current.end].size(); i++) {
                    Node next = graph[current.end].get(i);
                    if (!visited[next.end] && distance[next.end] > distance[current.end] + next.weight) {
                        distance[next.end] = distance[current.end] + next.weight;
                        pq.offer(new Node(next.end, distance[next.end]));
                    }
                }
            }

            //아이템 계산
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (distance[i] <= m) {
                    sum += items[i];
                }
            }
            if (sum > res) {
                res = sum;
            }
        }
        System.out.println(res);

    }
    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}