import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
    static Integer arr[];
    static Integer res[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        res = new Integer[m];
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            set.add(tmp);
        }

        arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        solve(0, 0, arr.length, m);
        System.out.println(sb);

    }
    static void solve(int depth, int start, int n, int m) {
        if (depth >= m) {
            for (Integer num : res) {
                sb.append(num+ " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            res[depth] = arr[i];
            solve(depth + 1, i, n, m);
        }
    }
}