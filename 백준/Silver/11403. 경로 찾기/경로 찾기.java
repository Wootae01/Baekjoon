import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] res = new int[n][n];
        boolean[] check;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            check = new boolean[n];
            queue.offer(i);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int j = 0; j < n; j++) {

                    if (!check[j]) {
                        if (arr[current][j] == 1) {
                            check[j] = true;
                            res[current][j] = 1;
                            res[i][j] = 1;
                            queue.offer(j);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(res[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
