import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList[] graph = new LinkedList[n + 1];
        int[] check = new int[n + 1];

        for(int i = 0; i <= n ;i++){
            graph[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);

        }

        Queue<Integer> q = new LinkedList<>();
        int baconNumber = Integer.MAX_VALUE;
        int person = 0;
        for(int i = 1; i <= n; i++){
            clearCheck(check);
            int result = 0;
            q.offer(i);
            check[i] = 0;
            while(!q.isEmpty()){
                int current = q.poll();

                for(int j = 0; j < graph[current].size(); j++){
                    int next = (int)graph[current].get(j);
                    if(check[next] == -1){
                        q.offer(next);
                        check[next] = check[current] + 1;
                        result += check[next];
                    }
                }

            }
            if(result < baconNumber){
                baconNumber = result;
                person = i;
            }
        }
        bw.write(person+"");
        bw.flush(); bw.close();

    }
    static void clearCheck(int[] check){
        for(int i = 0; i < check.length; i++){
            check[i] = -1;
        }
    }
}