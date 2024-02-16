import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int result = 0;
    static int row = 0;
    static int col = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(z((int)Math.pow(2, n), r, c) + "");

        bw.flush(); bw.close(); br.close();

    }
    static int z(int n, int r, int c){
        n /= 2;

        if(n == 0 || (row == r && col == c)){
            return result;
        } else{
            //왼쪽 위
            if(r < row + n && c < col + n){
            }
            //오른쪽 위
            else if(r < row + n && c >= col + n){
                result += n * n;
                col += n;
            } 
            //왼쪽 아래
            else if(r >= row + n && c < col + n){
                row += n;
                result += n * n * 2;
            } 
            //오른쪽 아래
            else if(r >= row + n && c >= col + n){
                row += n; col += n;
                result += n * n * 3;
            }
        }
        return z(n, r, c);
    }
}