import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int m;
    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point> house = new ArrayList<>();
    static boolean[] open;
    static int[][] chickenDistance;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    house.add(new Point(i, j));
                } else if (tmp == 2) {
                    chicken.add(new Point(i, j));
                }
                arr[i][j] = tmp;
            }
        }

        chickenDistance = new int[house.size()][chicken.size()];
        for (int i = 0; i < house.size(); i++) {
            Point home = house.get(i);
            for (int j = 0; j < chicken.size(); j++) {
                Point chick = chicken.get(j);
                chickenDistance[i][j] = Math.abs(chick.row - home.row) + Math.abs(chick.col - home.col);
            }
        }
        open = new boolean[chicken.size()];
        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int start, int count) {
        if (count == m) {
            int res = 0;
            for (int i = 0; i < house.size(); i++) {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++){
                    if (open[j]) {
                        min = Math.min(min, chickenDistance[i][j]);
                    }
                }
                res += min;
            }
            answer = Math.min(answer, res);
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, count + 1);
            open[i] = false;
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