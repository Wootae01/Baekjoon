import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        LinkedList[] graph = new LinkedList[n+1];
        int[] result = new int[n+1];
        boolean[] check = new boolean[n+1];

        for(int i = 0; i <=n; i++){
          graph[i] = new LinkedList<Integer>();
        }

        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        check[1] = true;
        while(!stack.isEmpty()){
            int current = stack.pop();
            for(int i = 0; i < graph[current].size(); i++){
                int next = (int)graph[current].get(i);
                if(!check[next]) {
                    result[next] = current;
                    check[next] = true;
                    stack.push(next);
                }
            }
        }

        for(int i = 2; i <= n; i++){
            bw.write(result[i] + "\n");
        }
        bw.flush(); bw.close();
    }
}
