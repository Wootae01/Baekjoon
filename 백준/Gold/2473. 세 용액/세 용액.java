import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int[] res = new int[3];

        // 세 개의 포인터를 이용한 탐색
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = (long)arr[i] + arr[left] + arr[right];
                if (Math.abs(sum) < min) {
                    res[0] = arr[i];
                    res[1] = arr[left];
                    res[2] = arr[right];
                    min = Math.abs(sum);
                }
                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        Arrays.sort(res);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}
