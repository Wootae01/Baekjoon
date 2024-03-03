import java.io.*;
import java.util.*;

public class Main {
    static int[] res;
    static boolean[] check;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        res = new int[m];
        check = new boolean[n];
        Arrays.sort(num);
        permutation(num, n ,m , 0);
    }
    static void permutation(int[] arr, int n, int m, int depth) throws IOException {
        if (depth == m) {

            for (int i = 0; i < m; i++) {
                bw.write(res[i]+" ");
            }
            bw.write("\n"); bw.flush();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(check[i]) continue;

            res[depth] = arr[i];
            check[i] = true;
            permutation(arr, n, m, depth+1);
            check[i] = false;
        }
    }


}