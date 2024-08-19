import java.util.*;
import java.io.*;
class Main{
    static int N;
    static int M;
    static int B;
    public static void main(String[] args) throws Exception{
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //풀이
        int t = Integer.MAX_VALUE;
        int h = -1;
        for (int k = 0; k <= 256; k++) {
            int one = 0;
            int two = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] > k) {
                        one += (arr[i][j] - k);
                    } else if (arr[i][j] < k) {
                        two += (k - arr[i][j]);
                    }
                }
            }

            if (two <= one + B) {
                int time = one * 2 + two;
                if (t > time) {
                    t = time;
                    h = k;
                } else if (t == time && h < k) {
                    h = k;
                }
            }
        }

        System.out.println(t + " " + h);

    }

}