import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        int[] info = new int[101];
        for (int i = 0; i < n + m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            info[start] = end;
        }

        int res = 0;
        boolean[] visited = new boolean[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if(current == 100){
                    flag = true;
                    break;
                }
                for (int j = 1; j <= 6; j++) {
                    int next = current + j;
                    if(next > 100 || visited[next]) continue;
                    if (info[next] > 0) {
                        queue.offer(info[current+j]);
                        visited[next] = true;
                    }
                    else{
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            if(flag){
                break;
            }
        }
        System.out.println(res - 1);
    }
}