import java.io.*;
import java.util.*;

class Main{
    static int n;
    static char[][] arr;
    static int[] drow = {1, -1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};
    static boolean[][] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //입력
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        check = new boolean[n][n];
        int res1 = countArea(false);
        int res2 = countArea(true);

        System.out.println(res1 + " " + res2);
    }

    static int countArea(boolean colorBlind) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                check[i][j] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    count++;
                    bfs(i,j, colorBlind);
                }
            }
        }
        return count;
    }

    static void bfs(int row, int col, boolean colorBlind) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(row, col));
        while (!q.isEmpty()) {
            Point current = q.poll();
            char color = arr[current.row][current.col];
            for (int i = 0; i < 4; i++) {
                int x = drow[i] + current.row;
                int y = dcol[i] + current.col;
                if (x >= 0 && x < n && y >= 0 && y < n && !check[x][y]) {
                    if (colorBlind && (color == 'R' || color == 'G')) {
                        if (arr[x][y] == 'R' || arr[x][y] == 'G') {
                            q.offer(new Point(x, y));
                            check[x][y] = true;
                        }
                    } else{
                        if (arr[x][y] == color) {
                            q.offer(new Point(x, y));
                            check[x][y] = true;
                        }
                    }
                }
            }
        }
    }
    static class Point{
        int row, col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}