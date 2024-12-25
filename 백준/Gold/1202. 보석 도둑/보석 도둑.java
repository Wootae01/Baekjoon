import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] bag = new Integer[K];
        Jewel[] jewels =  new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Arrays.sort(jewels);

        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = 0;
        for (int i = 0; i < K; i++) {
            int max = bag[i];
            while(n < N && jewels[n].m <= max){
                pq.add(jewels[n].v);
                n++;
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();   
            }
        }

        System.out.println(sum);
    }
    static class Jewel implements Comparable<Jewel>{
        int m;
        int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.m - o.m;
        }
    }
}