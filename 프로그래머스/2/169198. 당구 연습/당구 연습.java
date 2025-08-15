class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        /**
            음... 그냥 계산하면 될거 같은데
            
            근데 쿠션을 단쿠션에 맞추냐 장쿠션에 맞추냐를 따져야되네
            y = 0 y = m-1에 맞추는 경우, x = 0 or x = n-1에 맞추는 경우 계산 하여
            최소값 계산
            그냥 단순하게 4가지 경우 다 계산하면 되나?
            
        */
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int bx = balls[i][0];
            int by = balls[i][1];
            long best = Long.MAX_VALUE;
            
            // 1) 왼쪽 벽 (x = 0)
            // 제외조건: 같은 y 라인인데 목표가 시작점의 왼쪽에 있으면(쿠션 맞기 전에 맞춤)
            if (!(startY == by && bx < startX)) {
                long dx = startX + bx; // startX - (-bx) = startX + bx
                long dy = startY - by;
                best = Math.min(best, dx*dx + dy*dy);
            }
            
            // 2) 오른쪽 벽 (x = m)
            // 제외조건: 같은 y 라인인데 목표가 시작점의 오른쪽에 있으면
            if (!(startY == by && bx > startX)) {
                long dx = (2L * m - bx) - startX;
                long dy = startY - by;
                best = Math.min(best, dx*dx + dy*dy);
            }
            
            // 3) 아래 벽 (y = 0)
            // 제외조건: 같은 x 라인인데 목표가 시작점의 아래에 있으면
            if (!(startX == bx && by < startY)) {
                long dx = startX - bx;
                long dy = startY + by; // startY - (-by) = startY + by
                best = Math.min(best, dx*dx + dy*dy);
            }
            
            // 4) 위 벽 (y = n)
            // 제외조건: 같은 x 라인인데 목표가 시작점의 위에 있으면
            if (!(startX == bx && by > startY)) {
                long dx = startX - bx;
                long dy = (2L * n - by) - startY;
                best = Math.min(best, dx*dx + dy*dy);
            }
            
            answer[i] = (int) best;
        }
        
        return answer;
    }
}