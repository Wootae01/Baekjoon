import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            Map<String, String> map = new HashMap<>();
            int result = 1;
            int m = Integer.parseInt(br.readLine());
            for(int j = 0; j < m; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String type = st.nextToken();
                map.put(item, type);

            }

            Map<String, Integer> count = new HashMap<>();
            for(String kind : map.values()){
                if(count.containsKey(kind)){
                    count.put(kind, count.get(kind) + 1);
                } else{
                    count.put(kind, 1);
                }
            }

           for(int c : count.values()){
                result *= (c + 1);
           }
            result--;
            bw.write(result + "\n");
        }

        bw.flush(); bw.close();

    }
}
