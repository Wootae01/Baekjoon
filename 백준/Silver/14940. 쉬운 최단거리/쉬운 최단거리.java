import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] res = new int[n][m];
        for(int i =0; i < n; i++){
            for (int j = 0; j < m; j++) {
                res[i][j] = -1;
            }
        }
        boolean[][] check = new boolean[n][m];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0 ,0};
        Queue<Point> q = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int state = Integer.parseInt(st.nextToken());
                if(state == 2) {
                    q.offer(new Point(i, j));
                    check[i][j] = true;
                    res[i][j] = 0;
                } else if (state == 0) {
                    res[i][j] = 0;
                }
                arr[i][j] = state;
            }
        }


        while(!q.isEmpty()){
            Point current = q.poll();
            int cx = current.getX();
            int cy = current.getY();
            for (int i = 0; i < 4; i++) {
                int ddx = cx + dx[i];
                int ddy = cy + dy[i];

                if(0<=ddx && ddx < n && 0 <= ddy && ddy < m) {
                    if (!check[ddx][ddy] && arr[ddx][ddy] == 1) {
                        check[ddx][ddy] = true;
                        q.offer(new Point(ddx, ddy));
                        res[ddx][ddy] = res[cx][cy] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(res[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush(); bw.close();
    }

    static class Point {
        private int x;
        private int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }

    }
}