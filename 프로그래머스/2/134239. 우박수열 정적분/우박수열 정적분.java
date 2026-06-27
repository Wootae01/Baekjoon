
/**
    좌표 구하는건 어렵지 않을거 같고 5번만 하면 된다니까
    정적분 넓이를 어떻게 구하냐가 핵심인거 같네  ㅇㅇ
    적분 어떻게 하더라 ㅋㅋ
    아 그냥 사다리꼴 넓이를 구하면 되겠네
     a, b값도 정수이고 ㅇㅇ
     그냥 사다리꼴 넓이 구하고 더하면 되겠네 구간별로 
*/
import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        int n = 0;
        List<Point> list = new ArrayList<>();
        list.add(new Point(n, k));
        while(k > 1) {
            if (k % 2 == 0) {
                k = k /2;
            } else {
                k = k * 3 + 1;
            }
            
            list.add(new Point(++n, k));
        }
        
        // 누적 합 계산
        double[] sum = new double[n+1];
        for (int i = 0; i < list.size() - 1; i++) {
            Point p1 = list.get(i);
            Point p2 = list.get(i+1);
            sum[i+1] = sum[i] + (double)(p1.y + p2.y) * (p2.x - p1.x) / 2.0;
        }
        
        answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            if (a <= b) answer[i] = sum[b] - sum[a];
            else answer[i] = -1.0;
        }
        
        
        return answer;
    }
    
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y =y;
        }
        
    }
}