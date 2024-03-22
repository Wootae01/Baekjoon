import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        Integer count = 1;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(count, name);
            map2.put(name, count++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if('A' <= tmp.charAt(0) && tmp.charAt(0) <= 'Z'){
                sb.append(map2.get(tmp)+"\n");
            } else{
                sb.append(map.get(Integer.parseInt(tmp))+"\n");
            }
        }
        System.out.println(sb);
    }
}

