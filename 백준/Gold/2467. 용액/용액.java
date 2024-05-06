import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n-1;
        int res = Integer.MAX_VALUE;
        int resL = 0, resR = 0;
        int tmpL = 0, tmpR = 0;
        while (left < right) {

            int l = Math.abs(arr[left] + arr[left + 1]);
            int r = Math.abs(arr[right] + arr[right - 1]);
            int sum = Math.abs(arr[left] + arr[right]);

            if (l <= r && l <= sum) {
                tmpL = left;
                tmpR = left+1;
            }
            if (r <= l & r <= sum) {
                tmpL = right-1;
                tmpR = right;
            }
            if (sum <= r && sum <= l) {
                tmpL = left;
                tmpR = right;
            }

            if(Math.abs(arr[tmpR] + arr[tmpL]) < res){
                res = Math.abs(arr[tmpR] + arr[tmpL]);
                resL = tmpL;
                resR = tmpR;
            }

            if (arr[left]+ arr[right] > 0) {
                right--;
            } else{
                left++;
            }
        }
        System.out.printf("%d %d", arr[resL], arr[resR]);
    }
}