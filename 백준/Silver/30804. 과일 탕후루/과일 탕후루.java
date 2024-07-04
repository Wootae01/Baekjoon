import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; //탕후루에 꽂혀있는 과일 저장.

        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }

        //계산
        int i = 0; int j = 0;

        int[] count = new int[10];

        int total = 0; //전체 과일 수
        int res = -1;

        while (j < N) {

            if(total <= 2){
                if (count[arr[j]] == 0) {
                    total++;
                }

                count[arr[j]]++;

                //결과 갱신
                if(total <= 2 && res < j - i + 1){
                    res = j - i + 1;
                }
                j++;
            }

            else{
                count[arr[i]]--;
                if (count[arr[i]] == 0) {
                    total--;
                }
                i++;
            }
        }

        System.out.println(res);
    }
}