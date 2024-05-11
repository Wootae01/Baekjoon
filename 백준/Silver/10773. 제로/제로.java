import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] arr;
    static int[][] res;
    static boolean[]check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                stack.push(num);
            }
            else {
                stack.pop();
            }
        }

        int size = stack.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += stack.pop();
        }
        System.out.println(sum);


    }


}
