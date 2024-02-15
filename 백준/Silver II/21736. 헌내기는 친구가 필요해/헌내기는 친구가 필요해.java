import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        boolean check[][] = new boolean[n][m];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        char[][] arr = new char[n][m];
        int x = 0, y = 0;
        int result = 0;
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'I'){
                    x = i; y = j;
                }
            }
        }

        q.offer(new Point(x, y));
        check[x][y] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0 <= nx && nx < n && 0<= ny && ny < m && !check[nx][ny]){
                    char c = arr[nx][ny];
                    check[nx][ny] = true;
                    switch (c){
                        case 'X': break;
                        case 'O':
                            q.offer(new Point(nx, ny));
                            break;
                        case 'P':
                            q.offer(new Point(nx, ny));
                            result++;
                            break;
                    }
                }
            }
        }
        bw.write(result ==0 ? "TT" : result+"");
        bw.flush(); bw.close();

    }

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}