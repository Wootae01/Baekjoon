import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        boolean[][] check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Point> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        ArrayList<Integer> list = new ArrayList<>();
        int complex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    queue.offer(new Point(i, j));
                    check[i][j] = true;
                    int count = 1;

                    while (!queue.isEmpty()) {
                        Point current = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = current.row + dx[k];
                            int y = current.col + dy[k];
                            if (x < 0 || x >= n || y < 0 || y >= n) {
                                continue;
                            }

                            if (arr[x][y] == 1 && !check[x][y]) {
                                check[x][y] = true;
                                queue.offer(new Point(x, y));
                                count++;
                            }
                        }
                    }
                    complex++;
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(complex + "\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + "\n");
        }
        System.out.println(sb);
    }
    static class Point{
        int row, col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}