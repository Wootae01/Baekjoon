import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (isValid(arr, S, E, (E - S) / 2)) {
                sb.append("1\n");
            }
            else{
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isValid(int[] arr, int s, int e, int n) {
        for (int i = 0; i <= n; i++) {
            if (arr[s + i] != arr[e - i]) {
                return false;
            }
        }
        return true;
    }
}