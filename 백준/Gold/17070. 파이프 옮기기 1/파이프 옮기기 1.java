import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] arr;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n+1][n+1][3];
        dp[1][2][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 0) {
                    //가로
                    if(arr[i][j-1] == 0) {
                        dp[i][j][0] += dp[i][j - 1][0];
                        dp[i][j][0] += dp[i][j - 1][1];
                    }
                    //대각선
                    if(arr[i-1][j] == 0 && arr[i][j-1] == 0) {
                        dp[i][j][1] += dp[i - 1][j - 1][0];
                        dp[i][j][1] += dp[i - 1][j - 1][1];
                        dp[i][j][1] += dp[i - 1][j - 1][2];
                    }

                    //세로
                    if(arr[i-1][j] == 0) {
                        dp[i][j][2] += dp[i - 1][j][2];
                        dp[i][j][2] += dp[i - 1][j][1];
                    }
                }

            }
        }

        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }
}
