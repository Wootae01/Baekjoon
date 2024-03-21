import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] items = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][]dp = new int[n+1][k+1];
        for (int j = 1; j <= k; j++) { //무게
            for (int i = 1; i <= n; i++) { //아이템 개수
                dp[i][j] = dp[i-1][j];
                if (j - items[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], items[i][1] + dp[i-1][j - items[i][0]]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}

