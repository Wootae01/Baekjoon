import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        Queue<Long> q = new LinkedList<>();
        q.offer((a));
        int res = 0;
        while(!q.isEmpty()){
            res++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                long num = q.poll();
                if(num == b){
                    System.out.println(res);
                    return;
                }
                if(num > b){
                    continue;
                }
                q.offer(num * 2);
                q.offer(num * 10 + 1);

            }
        }
        System.out.println(-1);
    }
}