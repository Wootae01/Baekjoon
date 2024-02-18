import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        Set<Integer> set = new HashSet();
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        Integer[] sorted = set.toArray(new Integer[0]);
        Arrays.sort(sorted);

        for(int i =0; i < n; i++){
            bw.write(binarySearch(arr[i], sorted.length, sorted) +" ");
        }
        bw.flush(); bw.close();
    }

    static int binarySearch(int value, int n, Integer[] arr) {
        int start = 0;
        int end = n;
        int mid = 0;

        while(start < end){
            mid = (start + end) / 2;
            if(arr[mid] >= value){
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }
}