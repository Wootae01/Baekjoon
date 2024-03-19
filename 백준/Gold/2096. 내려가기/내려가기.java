import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp 계산
        int[][] max = new int[n][3];
        int[][] min = new int[n][3];
        for (int i = 0; i < 3; i++) {
            max[0][i] = arr[0][i];
            min[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + arr[i][0];
            max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + arr[i][1];
            max[i][2] = Math.max(max[i-1][2], max[i-1][1]) + arr[i][2];

            min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + arr[i][0];
            min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + arr[i][1];
            min[i][2] = Math.min(min[i-1][2], min[i-1][1]) + arr[i][2];
        }

        //출력
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(Math.max(max[n - 1][0], max[n - 1][1]), max[n - 1][2]) + " ");
        sb.append(Math.min(Math.min(min[n - 1][0], min[n - 1][1]), min[n - 1][2]));
        System.out.println(sb);
    }
}