import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		long[] dp = new long[101];
		dp[0] = 0; dp[1] = 1; dp[2] = 1;
		for(int i = 3; i <= 100; i++) {
			dp[i] = dp[i-3] + dp[i-2];
		}
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n]+ "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}