import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int nextX = x; int nextY = y;
            int lcm = M * N / gcd(M, N);
            while (nextX <= lcm && nextY <= lcm) {
                if (nextX == nextY) {
                    flag = true;
                    break;
                }
                else if (nextX > nextY) {
                    nextY = nextY + N;
                }
                else{
                    nextX = nextX + M;
                }
            }
            if (flag) {
                sb.append(nextX + "\n");
            }
            else{
                sb.append("-1\n");
            }
        }
        System.out.println(sb);
    }
    static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }
}