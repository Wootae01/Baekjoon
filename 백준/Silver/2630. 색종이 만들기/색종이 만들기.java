import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[128][128];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(isPainted(arr, 0, n, 0, n, 0)+"\n");
        bw.write(isPainted(arr, 0, n, 0, n, 1)+"");
        bw.flush(); bw.close();

    }
    public static int isPainted(int[][] arr, int start_row, int end_row, int start_col, int end_col, int color){
        int result = 0;
        int flag = 0;
        if(start_col + 1 >= end_col && start_row + 1 >= end_row){

            return color == arr[start_row][start_col] ? 1 : 0;
        }
        Loop1:
        for(int i = start_row; i < end_row; i++){
            for(int j = start_col; j < end_col; j++){
                if(arr[i][j] != color){
                    flag = 1;
                    break Loop1;
                }
            }
        }
        if(flag == 0){
            result++;
        } else{
            int mid_row = (start_row + end_row) / 2;
            int mid_col = (start_col + end_col) / 2;
            result += isPainted(arr, start_row, mid_row, start_col, mid_col, color); //1사분면
            result += isPainted(arr, start_row, mid_row, mid_col, end_col, color); //2사분면
            result += isPainted(arr, mid_row, end_row, start_col, mid_col, color); //3사분면
            result += isPainted(arr, mid_row, end_row, mid_col, end_col, color); //4사분면
        }
        
        return result;
    }

}