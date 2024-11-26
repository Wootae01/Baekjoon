import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        Map<Character, Integer> in = new HashMap<>();
        Map<Character, Integer> out = new HashMap<>();
        in.put('+', 5); in.put('-', 5); in.put('*', 10); in.put('/', 10);
        in.put('(', 20);in.put(')', 0);
        out.put('+', 5); out.put('-', 5); out.put('*', 10); out.put('/', 10);
        out.put('(', 0);out.put(')', 0);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else{
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                } else{
                    while (!stack.isEmpty() && in.get(c) <= out.get(stack.peek())) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}