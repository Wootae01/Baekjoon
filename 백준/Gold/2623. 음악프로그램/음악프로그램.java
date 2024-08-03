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

        List<Integer>[] graph = new List[N + 1];
        int[] inDree = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            for (int j = 1; j < tmp; j++) {
                int cur = Integer.parseInt(st.nextToken());
                graph[pre].add(cur);
                inDree[cur] += 1;
                pre = cur;
            }
        }

        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (inDree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur + "\n");
            for (int i = 0; i < graph[cur].size(); i++) {
                int node = graph[cur].get(i);
                inDree[node]--;
                if (inDree[node] == 0) {
                    queue.offer(node);
                }
            }
        }
        
        //사이클 확인
        for (int i = 1; i <= N; i++) {
            if (inDree[i] > 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb);

    }
}