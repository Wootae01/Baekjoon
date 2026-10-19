/**
    아 하나의 테이블에서 계속 돌리는구나 
    그럼 기록을 해야겠네 돌릴때마다
    
    
*/
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // 보드 초기화
        int n = 1;
        int[][] board = new int[rows + 1][columns + 1];
        for (int i = 1 ; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                board[i][j] = n++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int startY = queries[i][0];
            int startX = queries[i][1];
            int endY = queries[i][2];
            int endX = queries[i][3];
            
            // 배열 돌려
            int min = rotateArray(board, startY, startX, endY, endX);
            answer[i] = min;
            
        }
        return answer;
    }
    private int rotateArray(int[][] board, int startY, int startX, int endY, int endX) {
        // 위 
        
        int prev  = board[startY][startX];
        int min = prev;
        
        for (int x = startX + 1; x <= endX; x++) {
            int cur = board[startY][x];
            min = Math.min(min, cur);
            board[startY][x] = prev;
            prev = cur;
        }

        // 오른쪽
        for (int y = startY + 1; y <= endY; y++) {
            int cur = board[y][endX];
            min = Math.min(min, cur);
            board[y][endX] = prev;
            prev = cur;
        }

        // 아래
        for (int x = endX - 1; x >= startX; x--) {
            int cur = board[endY][x];
            min = Math.min(min, cur);
            board[endY][x] = prev;
            prev = cur;
        }

        // 왼쪽
        for (int y = endY - 1; y >= startY; y--) {
            int cur = board[y][startX];
            min = Math.min(min, cur);
            board[y][startX] = prev;
            prev = cur;
        }
        
        return min;
    }
}