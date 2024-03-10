import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] table = new int[n + 1][n + 1];

        // 표의 각 값 입력 받기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = scanner.nextInt();
            }
        }

        //dp 계산
        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = table[1][1];
        for (int i = 2; i <= n; i++) {
            dp[1][i] = dp[1][i-1] + table[1][i];
            dp[i][1] = dp[i-1][1] + table[i][1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + table[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();


            int result = dp[x2][y2] - (dp[x1 - 1][y2] + dp[x2][y1-1]) + dp[x1-1][y1-1];
            sb.append(result + "\n");
        }
        System.out.println(sb);

    }
}
