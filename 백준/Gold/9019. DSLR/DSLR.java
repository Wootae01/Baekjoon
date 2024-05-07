import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int A;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            Queue<CommandAndValue> queue = new LinkedList<>();
            queue.offer(new CommandAndValue("", A));
            String res = "";
            boolean[] check = new boolean[10000];
            check[A] = true;
            while (!queue.isEmpty()) {
                CommandAndValue current = queue.poll();
                int num = current.value;
                String str = current.command;
                int tmp = 0;

                if (num == B) {
                    res = str;
                    break;
                }

                //D
                tmp = num*2 % 10000;
                if(!check[tmp]) {
                    queue.offer(new CommandAndValue(str + "D", num * 2 % 10000));
                    check[tmp] = true;
                }

                //S
                if (num == 0) {
                    tmp = 9999;
                    if(!check[tmp]) {
                        queue.offer(new CommandAndValue(str + "S", tmp));
                        check[tmp] = true;
                    }
                }
                else{
                    tmp = num-1;
                    if(!check[tmp]) {
                        queue.offer(new CommandAndValue(str + "S", tmp));
                        check[tmp] = true;
                    }
                }

                //L
                tmp = (num % 1000) * 10 + num / 1000;
                if(!check[tmp]) {
                    queue.offer(new CommandAndValue(str + "L", tmp));
                    check[tmp] = true;
                }
                //R
                tmp = (num % 10) * 1000 + num/10;
                if(!check[tmp]) {
                    queue.offer(new CommandAndValue(str + "R", tmp));
                    check[tmp] = true;
                }

            }

            sb.append(res + "\n");
        }
        System.out.println(sb);
    }

    static class CommandAndValue{
        String command;
        int value;

        CommandAndValue(String command, int value) {
            this.command = command;
            this.value = value;
        }
    }
}