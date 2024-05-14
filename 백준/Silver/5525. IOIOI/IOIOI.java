import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] p = new char[2*n+1];
        for(int i = 0; i < 2 * n; i+= 2){
            p[i] = 'I';
            p[i+1] = 'O';
        }
        p[2*n] = 'I';

        int m = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int res = 0;
        for (int i = 0; i <= m - (2*n+1); i++) {
            if (S.substring(i, i + 2 * n + 1).equals(new String(p))) {
                res++;
            }
        }
        System.out.println(res);



    }


}
