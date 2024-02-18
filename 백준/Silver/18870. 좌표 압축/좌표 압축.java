import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] sorted = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }
        int rank = 0;
        Arrays.sort(sorted);
        for(int value : sorted){
            if(!map.containsKey(value)){
                map.put(value, rank++);
            }
        }

        for(int i =0; i < n; i++){
            bw.write(map.get(arr[i]) + " ");
        }
        bw.flush(); bw.close();
    }
}