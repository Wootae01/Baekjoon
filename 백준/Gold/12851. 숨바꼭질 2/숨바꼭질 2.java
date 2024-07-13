import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        if (N == K) {
            System.out.println("0\n1");
            return;
        }
        
        int[] time = new int[100001];
        int[] count = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        count[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int[] next = {current - 1, current + 1, current * 2};

            for (int i = 0; i < 3; i++) {
                if (next[i] >= 0 && next[i] <= 100000) {
                    if (time[next[i]] == 0) {
                        queue.offer(next[i]);
                        time[next[i]] = time[current] + 1;
                        count[next[i]] = count[current];

                    } else if (time[next[i]] == time[current] + 1) {
                        count[next[i]] += count[current];
                    }
                }
            }
        }
        System.out.println(time[K] + "\n" + count[K]);

    }
}