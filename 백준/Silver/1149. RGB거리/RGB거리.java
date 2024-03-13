import java.io.*;
import java.util.*;

class Main{
    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        //비용 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][RED] = Integer.parseInt(st.nextToken());
            arr[i][GREEN] = Integer.parseInt(st.nextToken());
            arr[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        //dp 초기값 설정
        int[][] dp = new int[n][3];
        dp[0][RED] = arr[0][RED];
        dp[0][GREEN] = arr[0][GREEN];
        dp[0][BLUE] = arr[0][BLUE];

        //dp 계산
        for (int i = 1; i < n; i++) {
            dp[i][RED] = Math.min(dp[i-1][GREEN], dp[i-1][BLUE]) + arr[i][RED];
            dp[i][GREEN] = Math.min(dp[i-1][RED], dp[i-1][BLUE]) + arr[i][GREEN];
            dp[i][BLUE] = Math.min(dp[i-1][GREEN], dp[i-1][RED]) + arr[i][BLUE];;
        }
        System.out.println(Math.min(Math.min(dp[n-1][RED], dp[n-1][GREEN]), dp[n-1][BLUE]));
    }
}