import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long result = mod(a, b, c);
        System.out.println(result);
    }

    static long mod(long a, long exponent, long c) {

        if (exponent == 1) {
            return a % c;
        }

        long tmp = mod(a, exponent/2, c);

        if (exponent % 2 == 1) {
            return ((tmp*tmp %c)* a % c) % c;
        } else{
            return tmp * tmp % c;
        }

    }
}