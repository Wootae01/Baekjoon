import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int total = 0;
        int res = Integer.MAX_VALUE;
        while (end <= N && start < N) {
            if (total < S) {
                if(end == N) {
                    break;
                }
                total += numbers[end++];
            }
            else{
                if (res > end - start) {
                    res = end - start;
                }
                total -= numbers[start++];
            }
        }
        if (res == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(res);
        }
    }
}