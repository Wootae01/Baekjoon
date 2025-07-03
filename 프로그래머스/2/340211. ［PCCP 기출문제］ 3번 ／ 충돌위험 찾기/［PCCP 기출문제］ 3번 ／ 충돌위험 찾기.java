import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int n = routes.length;
        int m = routes[0].length;

        int[][] cur = new int[n][2]; // 현재 위치(row, col)
        int[] des = new int[n];      // routes[i]상의 목표 포인트 인덱스 (1부터 시작)

        // cur 초기화
        for (int i = 0; i < n; i++) {
            int startIdx = routes[i][0] - 1;   
            cur[i][0] = points[startIdx][0];   // row
            cur[i][1] = points[startIdx][1];   // col
            des[i] = 1;                        // 첫 번째 목적지는 routes[i][1]
        }

      
        while (!isDone(des, m)) {
            answer += countCollisions(cur, des, m);
            move(points, routes, cur, des);
        }

        return answer;
    }

    private static int countCollisions(int[][] cur, int[] des, int limit) {
        Map<Long, Integer> cnt = new HashMap<>();
        for (int i = 0; i < cur.length; i++) {
            if (des[i] >= limit) continue;  // 이미 완료된 로봇 스킵
            
            long key = ((long)cur[i][0] << 32) | cur[i][1];
            cnt.put(key, cnt.getOrDefault(key, 0) + 1);
        }
        int collisions = 0;
        for (int c : cnt.values()) {
            if (c >= 2) collisions++;
        }
        return collisions;
    }

    private static boolean isDone(int[] des, int limit) {
        // 모든 des[i] 가 limit 이상이면 종료
        for (int d : des) {
            if (d < limit) return false;
        }
        return true;
    }

    private static void move(int[][] points, int[][] routes, int[][] cur, int[] des) {
        for (int i = 0; i < routes.length; i++) {
            calPoint(points, routes, cur, des, i);
        }
    }

    private static void calPoint(int[][] points, int[][] routes, int[][] cur, int[] des, int i) {
        int m = routes[i].length;
        if (des[i] >= m) return;  // 더 이동할 목적지가 없으면 리턴

        // 현재 목표 포인트 좌표
        int idx = routes[i][des[i]] - 1; 
        int des_r = points[idx][0];
        int des_c = points[idx][1];

        // 1) row 이동
        if (cur[i][0] != des_r) {
            cur[i][0] += (des_r > cur[i][0] ? +1 : -1);
        }
        // 2) col 이동
        else if (cur[i][1] != des_c) {
            cur[i][1] += (des_c > cur[i][1] ? +1 : -1);
        }
        // 3) 목표 도착
        else {
            des[i]++;  // 다음 목적지로
            calPoint(points, routes, cur, des, i);  // 재귀로 한 프레임에 남은 이동처리
        }
    }
}
