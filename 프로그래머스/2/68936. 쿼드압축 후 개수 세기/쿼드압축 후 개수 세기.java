
/**
    음 어려운데  
    일단 계속 배열을 4부분으로 나눠.. 이건가 
    아니면 반대로 계속 합쳐 이건가
*/
class Solution {
    public static int count0 = 0;
    public static int count1 = 0;
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        
        compress(arr, 0, arr.length, 0, arr.length);

        return new int[]{count0, count1};
    }
    
    private void compress(int[][] arr, int r1, int r2, int c1, int c2) {
        
        if(r2-r1 <= 1 || c2 - c1 <=1) {
            if (arr[r1][c1] == 0) {
                count0++;
            } else {
                count1++;
            }
            return;
        }
        
        int midR = (r1+r2) / 2;
        int midC = (c1+c2) / 2;
        if (check(arr, r1, r2, c1, c2)) {
            if (arr[r1][c1] == 0) {
                count0++;
            } else {
                count1++;
            }
        } else {
            compress(arr, r1, midR, c1, midC);
            compress(arr, r1, midR, midC, c2);
            compress(arr, midR, r2, c1, midC);
            compress(arr, midR, r2, midC, c2);    
        }
       
    }
    private boolean check(int[][] arr, int r1, int r2, int c1, int c2) {
        int n = arr[r1][c1];
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (arr[i][j] != n) return false;
            }
        }
        return true;
    }
}