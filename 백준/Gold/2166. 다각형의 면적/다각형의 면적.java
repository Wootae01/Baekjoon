import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[2][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());

        }

        double sum = 0;

        for (int i = 0; i < n; i++) {
           sum += (double)arr[0][i] * arr[1][(i+1) % n];
           sum -= (double)arr[0][(i+1) % n] * arr[1][i];
        }

        /*print*/
        System.out.printf("%.1f", Math.abs(sum / 2));
    }
}

