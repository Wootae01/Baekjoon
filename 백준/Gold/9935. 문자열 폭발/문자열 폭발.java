import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < str.length()) {
            stack.push(str.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean check = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        }else{
            System.out.println(sb);

        }
    }
}
