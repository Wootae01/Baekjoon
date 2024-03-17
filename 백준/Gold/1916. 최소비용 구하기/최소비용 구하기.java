
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        int n, m;
        boolean visited[];
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int[] dist;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());


        dist[startPoint] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startPoint, 0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;
            if(visited[cur] == true){
                continue;
            }

            visited[cur] = true;

            for(Node node : list.get(cur)){
                if(!visited[node.end] && dist[node.end] > dist[cur] + node.cost){
                    dist[node.end] = dist[cur] + node.cost;
                    pq.offer(new Node(node.end, dist[node.end]));
                }
            }
        }
        System.out.println(dist[endPoint]);
    }
    static class Node implements Comparable<Node>{
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}