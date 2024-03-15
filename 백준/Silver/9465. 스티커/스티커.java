import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        //입력 받기
        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //dp 계산
            int[][]dp = new int[2][n];
            if (n == 1) {
                int result = Math.max(arr[0][0], arr[1][0]);
                System.out.println(result);
                continue;
            }
            dp[0][0] = arr[0][0];
            dp[1][1] = dp[0][0] + arr[1][1];
            dp[1][0] = arr[1][0];
            dp[0][1] = dp[1][0] + arr[0][1];

            for (int j = 2; j < n; j++) {
                dp[0][j] = arr[0][j] + Math.max(dp[1][j-1], dp[1][j-2]);
                dp[1][j] = arr[1][j] + Math.max(dp[0][j-1], dp[0][j-2]);
            }

            int result = dp[0][n-1] > dp[1][n-1] ? dp[0][n-1] : dp[1][n-1];
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}