import java.util.*;

class Solution {
    /**
        목표 상태를 만들지 못하는 경우가 뭔지 모르겠네
        
    */
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        int n = beginning.length;
        int m = beginning[0].length;
        
        int [][] diff = new int[n][m];
        
        // xor 연산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               diff[i][j] = xor(beginning[i][j], target[i][j]);
            }
        }
        
        int res = 0;
        int[] row = new int[n];
        int[] col = new int[m];
        
        // 0번째 행을 뒤집지 않는 경우
        for (int j = 0; j < m; j++) {
            col[j] = xor(diff[0][j], 0);
        }
        
        for (int i = 0;  i< n; i++) {
            row[i] = xor(diff[i][0], col[0]);
        }
        res = count(row) + count(col);
        
        // 1번째 행을 뒤집는 경우
        int[] row1 = new int[n];
        int[] col1 = new int[m];
        int res1 = 0;
        for (int j = 0; j < m; j++) {
            col1[j] = xor(diff[0][j], 1);
        }
        
        for (int i = 0;  i< n; i++) {
            row1[i] = xor(diff[i][0], col1[0]);
        }
        res1 = count(row1) + count(col1);
        
        boolean check = false;
        if (res < res1) {
            check = false;
            answer = res;
        } else {
            check = true;
            answer = res1;
        }
        
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check) arr[i][j] = xor(row1[i], col1[j]);
                else arr[i][j] = xor(row[i], col[j]);
            }
        }
        
        
        // 검증
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (diff[i][j] != arr[i][j]) {
                    return -1;
                }
            }
        }
        
        return answer;
    }
    
    private static int count(int[] arr) {
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) x++;
        }
        return x++;
    }
    
    private static int xor(int x, int y) {
        if (x != y)     return 1;
        return 0;
    }
}