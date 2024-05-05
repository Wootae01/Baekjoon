import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int t;
    static int n;
    static String[] arr;
    static boolean[] check;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (n > 32) {
                sb.append(0 + "\n");
                continue;
            }
            arr = new String[n];
            check = new boolean[n];

            res = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                arr[j] = st.nextToken();
            }
            dfs(0, 0);
            sb.append(res + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == 3) {
            String[] select = new String[3];
            int k = 0;
            int distance = 0;

            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    select[k++] = arr[i];
                }
            }
            for(int i = 0; i < 4; i++){
                if(select[0].charAt(i) != select[1].charAt(i)){
                    distance++;
                }
                if(select[1].charAt(i) != select[2].charAt(i)){
                    distance++;
                }
                if(select[0].charAt(i) != select[2].charAt(i)){
                    distance++;
                }
            }

            res = Math.min(res, distance);
            return;
        }

        for (int i = start; i < n; i++) {

            if(!check[i]) {
                check[i] = true;
                dfs(i + 1, depth + 1);
                check[i] = false;
            }
        }
    }
}