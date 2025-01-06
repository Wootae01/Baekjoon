import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());

        System.out.println(fibonacci(N));
    }

    static long fibonacci(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[][] result = power(new long[][]{{1, 1}, {1, 0}}, n - 1);
        return result[0][0];
    }

    static long[][] power(long[][] matrix, long exp) {
        if (exp == 1) return matrix;

        long[][] half = power(matrix, exp / 2);
        long[][] result = multiply(half, half);

        if (exp % 2 == 1) {
            result = multiply(result, new long[][]{{1, 1}, {1, 0}});
        }

        return result;
    }

    static long[][] multiply(long[][] a, long[][] b) {
        return new long[][]{
            {(a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD,
                (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD},
            {(a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD,
                (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD}
        };
    }
}
