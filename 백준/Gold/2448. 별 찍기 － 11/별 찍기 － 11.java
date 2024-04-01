import java.io.*;
import java.util.*;

class Main{
    static int n;
    static char[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 2 * n; j++) {
                arr[i][j] = ' ';
            }
        }
        printStar(n, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 2 * n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static void printStar(int n, int row, int col) {
        if (n == 3) {
            arr[row][col] = '*';
            arr[row+1][col-1] = arr[row+1][col+1] = '*';
            arr[row+2][col-2] = arr[row+2][col-1] = arr[row+2][col] = arr[row+2][col+1] = arr[row+2][col+2] = '*';
            return;
        }

        printStar(n / 2, row, col);
        printStar(n/2, row + n/2, col+ n/2);
        printStar(n/2, row + n/2, col- n/2);
    }
}