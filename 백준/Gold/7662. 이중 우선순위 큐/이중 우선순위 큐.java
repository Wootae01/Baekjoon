import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (str.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (str.equals("D")) {
                    if (map.size() == 0) {
                        continue;
                    }
                    int num = 0;
                    if (n == -1) {
                        num = map.firstKey();
                    } else if (n == 1) {
                        num = map.lastKey();
                    }
                    map.put(num, map.get(num) - 1);
                    if (map.get(num) == 0) {
                        map.remove(num);
                    }
                }
            }
            if (map.size() == 0) {
                sb.append("EMPTY\n");
            } else{
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        System.out.println(sb);
    }
}