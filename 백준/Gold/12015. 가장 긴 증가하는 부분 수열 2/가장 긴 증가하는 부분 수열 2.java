import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 1;
        int[] ans = new int[N];
        ans[0] = arr[0];
        for (int i = 1; i < N; i++) {
            if (ans[res - 1] < arr[i]){
                ans[res++] = arr[i];
            }
            else {
                int find = binarySearch(0, res - 1, ans, arr[i]);
                ans[find] = arr[i];
            }
        }
        System.out.println(res);
    }
    static int binarySearch(int start, int end, int[] arr, int value) {

        if (start > end) {
            return start;
        }

        int mid = (start + end) / 2;
        if (arr[mid] < value) {
            return binarySearch(mid + 1, end, arr, value);
        } else if (arr[mid] > value) {
            return binarySearch(start, mid - 1, arr, value);
        } else{
            return mid;
        }

    }
}