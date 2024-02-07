import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];

        dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 3;

        for(int i = 4; i <= n; i++){

            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        bw.write(dp[n] + "");
        bw.flush(); bw.close();
    }
}