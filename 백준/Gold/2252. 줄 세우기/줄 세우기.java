import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[N+1];

        List<Integer>[] graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            inDegree[b] += 1;
        }

        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current + " ");
            for (int i = 0; i < graph[current].size(); i++) {
                int next = graph[current].get(i);
                inDegree[next] -= 1;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        System.out.println(sb);
    }
}