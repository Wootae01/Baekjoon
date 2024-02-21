import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];
        dist[n] = 0;
        visited[n] = true;
        q.offer(n);

        while(!q.isEmpty()){
            int x = q.poll();
            if(x == k){
                System.out.println(dist[x]);
                break;
            } else{
                if(x - 1 >= 0 &&!visited[x - 1]){
                    dist[x - 1] = dist[x] + 1;
                    visited[x - 1] = true;
                    q.offer(x - 1);
                }
                if(x + 1 <= 100000 &&!visited[x + 1]){
                    dist[x + 1] = dist[x] + 1;
                    visited[x + 1] = true;
                    q.offer(x + 1);
                }
                if(x * 2 <= 100000 && !visited[x * 2]){
                    dist[x * 2] = dist[x] + 1;
                    visited[x * 2] = true;
                    q.offer(x * 2);
                }
            }
        }

    }
}