import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int res = 0;
        int count = 0;
        char pre = 'I';
        boolean check = false;

        for (int i = 0; i < m; i++) {
            char ch = S.charAt(i);
            if (ch == 'I') {
                if (pre == 'O' && check) {
                    if (count == n) {
                        res++;
                        count--;
                    }
                } else {
                    count = 0;
                }
                pre = 'I';
                check = true;
            }
            else if (ch == 'O') {
                if (pre == 'I' && check) {
                    pre = 'O';
                    count++;
                } else {
                    check = false;
                    count = 0;
                }
            }
        }

        System.out.println(res);
    }
}