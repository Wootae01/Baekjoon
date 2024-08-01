
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

class Main{
    static int[][] check;
    static char[][] info;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        info = new char[N][M];
        check = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                info[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }
        System.out.println(res);

    }

    static int dfs(int m, int n) {
        if (check[m][n] == 1) {
            res++;
            return 2;
        } else if (check[m][n] == 2) {
            return 2;
        } else{
            check[m][n] = 1;
            if (info[m][n] == 'L') {
                check[m][n] = dfs(m, n - 1);
            } else if (info[m][n] == 'R') {
                check[m][n] = dfs(m, n + 1);
            } else if (info[m][n] == 'U') {
                check[m][n] = dfs(m - 1, n);
            } else if (info[m][n] == 'D') {
                check[m][n] = dfs(m + 1, n);
            }
            return 2;
        }
    }


}