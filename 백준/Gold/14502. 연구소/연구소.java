import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int[][] arr;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    int tmp = bfs(list.get(i), list.get(j), list.get(k));
                    if (max < tmp) {
                        max = tmp;
                    }
                }
            }
        }
        System.out.println(max);
    }

    static int bfs(Point x, Point y, Point z) {
        //상하좌우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        arr[x.row][x.col] = 1;
        arr[y.row][y.col] = 1;
        arr[z.row][z.col] = 1;

        Queue<Point> queue = new LinkedList<>();
        boolean[][] check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    queue.offer(new Point(i, j));
                    check[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + dr[i];
                int nextCol = current.col + dc[i];

                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                    if (!check[nextRow][nextCol] && arr[nextRow][nextCol] == 0) {
                        queue.offer(new Point(nextRow, nextCol)); //감염 시킴
                        check[nextRow][nextCol] = true;
                    }
                }
            }
        }

        //count
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!check[i][j] && arr[i][j] == 0) {
                    count++;
                }
            }
        }

        arr[x.row][x.col] = 0;
        arr[y.row][y.col] = 0;
        arr[z.row][z.col] = 0;

        return count;
    }

    static class Point{
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}