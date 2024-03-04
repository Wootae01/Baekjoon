import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt((str.charAt(j-1))+"");
            }
        }

        Point node = new Point(1, 1);
        boolean check[][] = new boolean[n+1][m+1];
        Queue<Point> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] res = new int[n + 1][m + 1];
        res[1][1] = 1;
        q.offer(node);
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (0 < x && x <= m && 0 < y && y <= n) {
                    if (!check[y][x] && arr[y][x] == 1) {
                        q.offer(new Point(x, y));
                        res[y][x] = res[p.y][p.x] + 1;
                        check[y][x] = true;
                    }
                }
            }
        }
        System.out.println(res[n][m]);
    }
    static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}