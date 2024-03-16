import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        //입력 받기
        int[] arr = new int[n];
        int[] result = new int[n];
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        permutation(arr, result, n, m, check, 0);

    }

    static void permutation(int[] arr, int[] result, int n, int m, boolean[] check, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(result[i]+" ");
            }
            System.out.println(sb);
            return;
        }

        int prev = -1;

        for (int i = 0; i < n; i++) {
            if(prev == arr[i] || check[i]){
                continue;
            }
            check[i] = true;
            result[depth] = arr[i];
            prev = arr[i];

            permutation(arr, result, n, m, check, depth+1);
            check[i] = false;
        }
    }

}