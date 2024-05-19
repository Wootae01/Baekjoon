import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int R;
    static int C;
    static int res;
    static boolean[] check = new boolean[26];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        check[arr[0][0] - 'A'] = true;
        dfs(new Point(0, 0), 1);
        System.out.println(res);
    }
    static class Point{
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static void dfs(Point current, int sum) {
        if (sum > res) {
            res = sum;
        }

        for(int i = 0; i < 4; i++) {
            int r = current.r + dr[i];
            int c = current.c + dc[i];

            if (0 <= r && r < R && 0 <= c && c < C) {
                if (!check[arr[r][c] - 'A']) {
                    check[arr[r][c] - 'A'] = true;
                    dfs(new Point(r, c), sum + 1);
                    check[arr[r][c] - 'A'] = false;
                }
            }
        }
    }
}