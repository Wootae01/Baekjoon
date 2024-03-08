
import java.awt.*;
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[n][m][h];
        Queue<Point> q = new LinkedList();
        boolean[][][] check = new boolean[n][m][h];
        int result = 0;

        //위 아래 왼쪽 오른쪽 앞 뒤
        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, 0, 1, -1};
        int[] dz = {1, -1, 0, 0, 0, 0};

        //토마토 상태 입력받기 상태가 1인거 큐에 저장.
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int status = Integer.parseInt(st.nextToken());
                    if (status == 1) {
                        q.offer(new Point(k, j, i));
                        check[j][k][i] = true;
                    }

                    tomato[j][k][i] = status;
                }
            }
        }

        if(isRipe(m, n, h, tomato)){
            System.out.println(0);
            return;
        }

        //bfs
        while (!q.isEmpty() && !isRipe(m, n, h, tomato)) {
            result++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point current = q.poll();

                for (int j = 0; j < 6; j++) {
                    int x = current.x + dx[j];
                    int y = current.y + dy[j];
                    int z = current.z + dz[j];

                    if (0 <= x && x < m && 0 <= y && y < n && 0 <= z && z < h) {
                        int status = tomato[y][x][z];
                        //토마토 상태가 0이면
                        if(status == 0){
                            tomato[y][x][z] = 1;
                            q.offer(new Point(x, y, z));
                        }
                    }
                }

            }

        }
        if(isRipe(m, n, h, tomato)){
            System.out.println(result);
        } else{
            System.out.println(-1);
        }
    }

    private static boolean isRipe(int m, int n, int h, int[][][] tomato) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if(tomato[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class Point{
        int x, y, z;
        Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}