import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static int[] board;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        solveNQueen(0);
        System.out.println(result);
    }

    static void solveNQueen(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                solveNQueen(row + 1);
            }
        }
    }

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 있거나 대각선에 있으면 공격할 수 있음
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
