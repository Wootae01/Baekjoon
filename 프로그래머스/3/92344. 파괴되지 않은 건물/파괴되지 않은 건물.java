class Solution {
    /**
        아 skill 길이가 길구나
        브루트포스가 아니면 음..
        board 값을 한번에 업데이트 할 수 있다고?
        사각형 형태로 공격을 한다.... 여기 뭐가 있나?
        이게 되나? 이차원 배열인데
        일차원이면 가능한데
        
        와 이걸 어떻게 생가햐ㄴ...
        
    */
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] diff = new int[board.length + 1][board[0].length + 1];
        for (int s = 0; s < skill.length; s++) {
            int type = skill[s][0];
            int r1 = skill[s][1];
            int c1 = skill[s][2];
            int r2 = skill[s][3];
            int c2 = skill[s][4];
            int degree = skill[s][5];
            int val = (type == 1) ? -degree : degree;

            diff[r1][c1] += val;
            diff[r1][c2+1] -= val;
            diff[r2+1][c1] -= val;
            diff[r2+1][c2+1] += val;
            
        }
        
        // 가로 누적합
        for (int i = 0; i < diff.length; i++) {
            for (int j = 1; j < diff[i].length; j++) {
                diff[i][j] += diff[i][j-1];
            }
        }
        
        // 세로 누적합
        for (int j = 0; j < diff[0].length; j++) {
            for (int i = 1; i < diff.length; i++) {
                diff[i][j] += diff[i-1][j];
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += diff[i][j];
                if (board[i][j] >= 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}