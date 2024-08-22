import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int[][] matrix;
    static int N;
    static Long B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                matrix[i][j] = matrix[i][j] % 1000;
            }
        }

        int[][] result = recursive(B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static int[][] recursive(Long n) {
        if (n == 1) {
            return matrix;
        }
        int[][] half = recursive(n / 2);

        if (n % 2 == 0) {
            return multiplication(half, half);
        } else{
            return multiplication(multiplication(half, half), matrix);
        }
    }

    public static int[][] multiplication(int[][] a, int[][] b) {

        int[][] tmp = new int[N][N];

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += a[k][j] * b[j][i];
                    sum = sum % 1000;
                }
                tmp[k][i] = sum;
            }
        }
        return tmp;
    }
}