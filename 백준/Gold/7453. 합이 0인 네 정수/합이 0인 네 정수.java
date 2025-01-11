import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[N*N];
        int[] CD = new int[N*N];

        int k = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                AB[k] = A[i] + B[j];
                CD[k] = C[i] + D[j];
                k++;
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        long res = 0;
        for (int i = 0; i < N*N; i++) {
            res += countResult(CD, -AB[i]);
        }
        System.out.println(res);
    }

    static int countResult(int[] arr, int target) {
        int low = lowerBound(arr, target);
        int up = upperBound(arr, target);

        return up - low;
    }
    static int lowerBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) /2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else{
                end = mid;
            }
        }
        return start;
    }

    static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) /2;
            if (arr[mid] <= target) {
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}