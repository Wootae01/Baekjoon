import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int res = 0;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = true;
                dfs(i, j, arr[i][j], 0);
                check[i][j] = false;
            }
        }
        System.out.println(res);

    }

    static void dfs(int x, int y, int sum, int depth){

        if (depth >= 3) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int row = x + dx[i];
            int col = y + dy[i];

            if (row >= n || col >= m || row < 0 || col < 0) {
                continue;
            }
            if (!check[row][col]) {
                if (depth == 1) {
                    check[row][col] = true;
                    dfs(x, y, sum + arr[row][col], depth + 1);
                    check[row][col] = false;
                }

                check[row][col] = true;
                dfs(row, col, sum + arr[row][col], depth + 1);
                check[row][col] = false;

            }
        }
    }

}
