import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<PosTime> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        queue.offer(new PosTime(n, 0));
        visited[n] = true;

        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            PosTime current = queue.poll();
            int sec = current.time;
            int location = current.pos;

            if (location == k) {
                min = Math.min(min, sec);
                continue;
            }
            if(location * 2 <= 100000 && !visited[location * 2]){
                queue.offer(new PosTime(location  * 2, sec));
                visited[location * 2] = true;
            }
            if(location-1 >= 0 && !visited[location-1]){
                queue.offer(new PosTime(location - 1, sec + 1));
                visited[location-1] = true;
            }
            
            if(location + 1 <= 100000 && !visited[location + 1]){
                queue.offer(new PosTime(location + 1, sec + 1));
                visited[location + 1] = true;
            }


        }
        System.out.println(min);

    }

    static class PosTime{
        int pos;
        int time;

        PosTime(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}

