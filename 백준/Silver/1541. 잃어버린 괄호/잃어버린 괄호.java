import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String equation = br.readLine();
        StringTokenizer st = new StringTokenizer(equation, "+-", true);

        int sum = 0;
        int flag = 0;
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            if (tmp.equals("+")) {
                continue;
            } else if (tmp.equals("-")) {
                flag = 1;
            } else {
                if (flag == 0) {
                    sum += Integer.parseInt(tmp);
                } else if (flag == 1) {
                    sum -= Integer.parseInt(tmp);
                }

            }
        }
        bw.write(sum+"");
        bw.flush(); bw.close();
    }
}