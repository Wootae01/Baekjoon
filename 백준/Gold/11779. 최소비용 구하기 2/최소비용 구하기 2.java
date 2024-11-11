import javax.print.attribute.IntegerSyntax;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Node>[] graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] trace = new int[N + 1];

        dist[start] = 0;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.index == end) {
                break;
            }
            if(dist[current.index] < current.cost) continue;

            for (int i = 0; i < graph[current.index].size(); i++) {
                Node next = graph[current.index].get(i);
                if (dist[next.index] > dist[current.index] + next.cost) {
                    trace[next.index] = current.index;
                    dist[next.index] = dist[current.index] + next.cost;
                    pq.offer(new Node(next.index, current.cost + next.cost));
                }
            }
        }
        sb.append(dist[end] + "\n");
        int count = 0;
        int tmp = end;
        Stack<Integer> stack = new Stack();
        while (tmp != 0) {
            count++;
            stack.push(tmp);
            tmp = trace[tmp];
        }
        sb.append(count + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);

    }
    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}