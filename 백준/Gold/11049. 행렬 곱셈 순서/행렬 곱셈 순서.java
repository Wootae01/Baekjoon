import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] r = new int[N];
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N][N];
        for (int length = 1; length < N; length++) {
            for (int i = 0; i + length < N; i++) {
                int j = i + length;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + r[i] * c[k] * c[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }

            }
        }
        System.out.println(dp[0][N - 1]);
    }
}