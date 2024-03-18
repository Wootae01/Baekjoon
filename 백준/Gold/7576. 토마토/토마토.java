import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Point> q = new LinkedList<>();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        //입력, 1인 경우 q에 넣기
        boolean[][] check = new boolean[n][m];
        int[][] tomato = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int state = Integer.parseInt(st.nextToken());
                if (state == 1) {
                    q.offer(new Point(i, j));
                    check[i][j] = true;
                } else if (state == -1) {
                    check[i][j] = true;
                }
                tomato[i][j] = state;
            }
        }

        if (isRipe(n, m, check)) {
            System.out.println(0);
            return;
        }

        //상하좌우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int result = 0;
        while (!q.isEmpty()) {
            result++;
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Point current = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = current.x + dx[i];
                    int y = current.y + dy[i];

                    if(x < 0 || x >= n || y < 0 || y >= m || check[x][y]){
                        continue;
                    }

                    if (tomato[x][y] == 0) {
                        q.offer(new Point(x, y));
                        check[x][y] = true;
                    } else if (tomato[x][y] == -1) {
                        check[x][y] = true;
                    }
                }
            }

        }
        if (!isRipe(n, m, check)){
            System.out.println(-1);
        }else{
            System.out.println(result - 1);
        }


    }

    private static boolean isRipe(int n, int m, boolean[][] check) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x; this.y = y;
        }
    }

}