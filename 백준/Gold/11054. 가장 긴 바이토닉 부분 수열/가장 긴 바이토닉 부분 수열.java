import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] < arr[j] && dp1[j] < dp1[i] + 1) {
                    dp1[j] = dp1[j] + 1;
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j] && dp2[j] < dp2[i] + 1) {
                    dp2[j] = dp2[i] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (dp1[i] + dp2[i] > max) {
                max = dp1[i] + dp2[i];
            }
        }
        System.out.println(max-1);
    }
}
