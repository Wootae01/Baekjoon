import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        permutation(1, n, m, 1, 0, arr);

    }
    static void permutation(int start, int end, int m, int value, int depth, int[] arr) {
        if(m <= depth){
            for(int i = 1; i <= m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = value; i <= end; i++) {
                arr[start] = i;
                permutation(start + 1, end, m, i, depth + 1, arr);
            }
        }
    }
}