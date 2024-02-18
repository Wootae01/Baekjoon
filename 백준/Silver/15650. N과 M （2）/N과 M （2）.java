import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        Permutation(1, n, m, 0, arr);
        bw.flush(); bw.close();
    }

    static void Permutation(int start, int end, int m, int depth, int[] arr) throws IOException{
        if(depth >= m){
            for(int i = 0; i < m; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = start; i <= end; i++){
            arr[depth] = i;
            Permutation(i + 1, end, m, depth+1, arr);
        }

    }

}