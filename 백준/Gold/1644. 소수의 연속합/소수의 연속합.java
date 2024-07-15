import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //1. 소수를 찾는다.
        boolean[] checkPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            checkPrime[i] = true;
        }

        //에라토스테네스의 체
        for (int i = 2; i * i <= N; i++) {
            if (checkPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    checkPrime[j] = false;
                }
            }
        }

        //2. 소수의 연속된 합을 찾는다. 투 포인터
        int p1 = 2; int p2 = 2;
        int count = 0;
        int sum = 0;

        while (p2 <= N + 1 && p1 <= N) {
            if (sum < N) {
                if (p2 <= N && checkPrime[p2]) {
                    sum += p2;
                }
                p2++;
            } else if (sum > N) {
                if (p1 <= N && checkPrime[p1]) {
                    sum -= p1;
                }
                p1++;
            } else{
                count++;
                while (!checkPrime[p1]) {
                    p1++;
                }
                sum -= p1;
                p1++;
            }
        }

        System.out.println(count);
    }

}
