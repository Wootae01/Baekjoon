import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static boolean[] finished;
    static boolean[] visited;
    static int[] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            finished = new boolean[N + 1];
            visited = new boolean[N + 1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            sb.append(N - count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int current) {
        visited[current] = true;
        int next = arr[current];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int tmp = next; tmp != current; tmp = arr[tmp]) {
                count++;
            }
            count++;
        }
        finished[current] = true;
    }
}