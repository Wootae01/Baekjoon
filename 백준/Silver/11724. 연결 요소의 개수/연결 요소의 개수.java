import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List[] graph = new LinkedList[n + 1];
        for(int i = 1; i <= n; i++){
            graph[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int[] check = new int[n + 1];
        int current = 1;

        while(true) {
            if(check[current] == 1) {
                result++;
                boolean flag = false;
                for (int i = 1; i <= n; i++) {
                    if(check[i] == 0){
                        current = i;
                        flag = true;
                        break;
                    }
                }
                if(!flag) break;
            }

            stack.push(current);

            while (!stack.isEmpty()) {
                current = stack.pop();
                if (check[current] == 1) continue;

                check[current] = 1;
                for (int i = 0; i < graph[current].size(); i++) {
                    stack.push((Integer) graph[current].get(i));
                }
            }
        }
        bw.write(result+"");
        bw.flush(); bw.close();
    }

}