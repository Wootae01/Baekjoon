import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, W;
    static int[] dist;
    static List<Road>[] a;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            a = new List[N + 1];
            for (int i = 0; i <= N; i++) {
                a[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                a[start].add(new Road(end, weight));
                a[end].add(new Road(start, weight));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                a[start].add(new Road(end, -weight));
            }

            boolean hasNegativeCycle = false;
            for (int start = 1; start <= N; start++) {
                if (bellmanFord(start)) {
                    hasNegativeCycle = true;
                    break;
                }
            }

            sb.append(hasNegativeCycle ? "YES\n" : "NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;
            for (int u = 1; u <= N; u++) {
                for (Road road : a[u]) {
                    if (dist[u] != INF && dist[road.end] > dist[u] + road.weight) {
                        dist[road.end] = dist[u] + road.weight;
                        update = true;
                    }
                }
            }
            if (!update) break;
        }

        if (update) {
            for (int u = 1; u <= N; u++) {
                for (Road road : a[u]) {
                    if (dist[u] != INF && dist[road.end] > dist[u] + road.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static class Road {
        int end;
        int weight;

        Road(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}