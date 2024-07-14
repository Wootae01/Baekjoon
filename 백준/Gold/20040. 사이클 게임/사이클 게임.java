import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        int res = 0;
        boolean cycleFound = false;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (union(start, end) && !cycleFound) {
                res = i + 1;
                cycleFound = true;
            }
        }

        if (!cycleFound) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }
    }

    static int find(int x) {
        if (arr[x] == x) {
            return x;
        } else {
            return arr[x] = find(arr[x]);
        }
    }

    static boolean union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);

        if (p1 == p2) {
            return true;
        }

        arr[p2] = p1;
        return false;
    }
}
