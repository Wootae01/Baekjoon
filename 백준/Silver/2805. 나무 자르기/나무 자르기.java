import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int left = 0;
        int right = arr[0];

        int result = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] > mid){
                    sum += (arr[i] - mid);
                } else{
                    break;
                }
            }
            if(sum >= m){
                left = mid + 1;
                result = mid;
            } else{
                right = mid - 1;
            }
        }
        bw.write(result + ""); // 결과 출력
        bw.flush();
        bw.close();
        br.close();
    }

}