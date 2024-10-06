import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R][C];
        int a1 = -1, a2 = -1; //공기 청정기 위치
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    if (a1 == -1) {
                        a1 = i;
                    } else{
                        a2 = i;
                    }
                }
            }
        }


        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int k = 0; k < T; k++) {

            //미세먼지 확산
            int[][] tmp = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(arr[i][j] == 0) continue;
                    int dif = arr[i][j] / 5;
                    for (int l = 0; l < 4; l++) {
                        int r = i + dr[l];
                        int c = j + dc[l];
                        if(r < 0 || r >= R || c < 0 || c >= C || arr[r][c] == -1) continue;
                        tmp[r][c] += dif;
                        tmp[i][j] -= dif;
                    }
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[i][j] += tmp[i][j];
                }
            }

            //공기청정기 작동
            workPurifier(a1, a2, arr, C, R);
        }
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res += arr[i][j];
            }
        }
        System.out.println(res + 2);
    }

    private static void workPurifier(int a1, int a2, int[][] arr, int C, int R) {
        //반시계
        for(int i = a1 - 1; i  > 0; i--) arr[i][0] = arr[i-1][0];
        for(int j = 0; j < C - 1; j++) arr[0][j] = arr[0][j+1];
        for(int i = 0; i < a1; i++) arr[i][C-1] = arr[i+1][C-1];
        for(int j = C-1; j > 1; j--) arr[a1][j] = arr[a1][j-1];
        arr[a1][1] = 0;
        //시계
        for (int i = a2 + 1; i < R - 1; i++) arr[i][0] = arr[i + 1][0];
        for(int j = 0; j < C - 1; j++) arr[R-1][j] = arr[R-1][j+1];
        for(int i = R-1; i > a2; i--) arr[i][C-1] = arr[i-1][C-1];
        for(int j = C-1; j > 1; j--) arr[a2][j] = arr[a2][j-1];
        arr[a2][1] = 0;
    }
}