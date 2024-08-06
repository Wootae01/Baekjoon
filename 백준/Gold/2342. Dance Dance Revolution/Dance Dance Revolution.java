import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int size = arr.length - 1;

        int[][] cost = {
                {0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}
        };


        int[][][] dp = new int[5][5][size + 1];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < size + 1; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;

        for (int i = 0; i < size; i++) {
            int x = Integer.parseInt(arr[i]);

            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    if(dp[left][right][i] == Integer.MAX_VALUE) continue;

                    if (left != x) { //오른발 움직이는 경우
                        dp[left][x][i + 1] = Math.min(dp[left][right][i] + cost[right][x], dp[left][x][i + 1]);
                    }
                    if (right != x) { //왼발 움직이는 경우
                        dp[x][right][i + 1] = Math.min(dp[left][right][i] + cost[left][x], dp[x][right][i + 1]);
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (res > dp[i][j][size]) {
                    res = dp[i][j][size];
                }
            }
        }
        System.out.println(res);
    }
}