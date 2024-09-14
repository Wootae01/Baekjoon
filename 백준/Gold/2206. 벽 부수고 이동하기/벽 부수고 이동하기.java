import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main{
    static int[][] arr;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = tmp.charAt(j - 1) - '0';
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N + 1][M + 1][2];
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        queue.offer(new Point(1, 1, 0));
        visited[1][1][0] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Point cur = queue.poll();
                if (cur.row == N && cur.col == M) {
                    return count;
                }

                int wallBroken = cur.wallBroken;
                for (int i = 0; i < 4; i++) {
                    int nextR = cur.row + dr[i];
                    int nextC = cur.col + dc[i];
                    if (nextR > 0 && nextR <= N && nextC > 0 && nextC <= M) {
                        if (arr[nextR][nextC] == 0 && !visited[nextR][nextC][cur.wallBroken]) {
                            visited[nextR][nextC][wallBroken] = true;
                            queue.offer(new Point(nextR, nextC, wallBroken));
                        }
                        if (!visited[nextR][nextC][1] && arr[nextR][nextC] == 1 && wallBroken == 0) {
                            visited[nextR][nextC][1] = true;
                            queue.offer(new Point(nextR, nextC, 1));
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    static class Point{
        int row, col, wallBroken;

        public Point(int row, int col, int wallBroken) {
            this.row = row;
            this.col = col;
            this.wallBroken = wallBroken;
        }
    }
}