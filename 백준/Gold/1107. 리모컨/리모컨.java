import java.io.*;
import java.util.*;

class Main{
    static boolean[] broken;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        broken = new boolean[10];
        if(m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                broken[tmp] = true;
            }
        }

        int result = Math.abs(n - 100);
        for (int i = 0; i <= 999999; i++) {
            int tmp = i;
            int len = 0;
            boolean flag = false;
            while (true) {
                if(broken[tmp % 10]){
                    flag = true;
                    break;
                }
                if(tmp >= 10) {
                    len++;
                    tmp /= 10;
                } else{
                    len++;
                    break;
                }
            }
            if (!flag) {
                result = Math.min(result, len + Math.abs(n - i));
            }
        }
        System.out.println(result);
    }
}