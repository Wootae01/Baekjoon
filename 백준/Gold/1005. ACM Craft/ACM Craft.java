import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] delay = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] graph = new ArrayList[N + 1];
            int[] inDegree = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                inDegree[y]++;
                graph[x].add(y);
            }

            int W = Integer.parseInt(br.readLine());


            //위상 정렬
            Queue<Integer> queue = new LinkedList<>();
            int[] curDelay = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    curDelay[i] = delay[i];
                }
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int i = 0; i < graph[cur].size(); i++) {
                    int next = graph[cur].get(i);
                    inDegree[next]--;

                    if (curDelay[next] < curDelay[cur] + delay[next]) {
                        curDelay[next] = curDelay[cur] + delay[next];
                    }
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            sb.append(curDelay[W] + "\n");
        }
        System.out.println(sb);

    }
}