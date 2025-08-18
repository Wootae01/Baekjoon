class Solution {
    public int solution(String[] board) {
        /**
            틱택토 진행 했을 때 나올 수 있는 게임 상황인지 판단해라..
            1. 게임 결과가 나오면 게임을 끝내야됨.
            2. O와 X의 수가 같거나 O가 X보다 1개 더 많아야됨.
                X가 O보다 더 많을 수는 없음.
                
            그냥 위 조건 if문으로 하면 될거같은데?
            1. O 개수, X 개수 count
                O가 빙고일 때는 O개수가 X 개수보다 1 더 많아야됨
                X가 빙고일 때는 O개수와 X 개수가 같아야됨
            2. 가로, 세로, 대각선 확인
            
        */
        int answer = -1;
        
        //1. O 개수, X 개수 확인
        int countO = countCharacter(board, 'O');
        int countX = countCharacter(board, 'X');
        
        if(countO < countX || countO - countX > 1) return 0;
        
        // 2. 가로 세로 대각선 확인
        int countBingoO = 0;
        int countBingoX = 0;
        
        countBingoO += countDiagonal(board, 'O');
        countBingoX += countDiagonal(board, 'X');
        
        countBingoO += countCol(board, 'O');
        countBingoX += countCol(board, 'X');
        
        countBingoO += countRow(board, 'O');
        countBingoX += countRow(board, 'X');
        
        if(countBingoX > 0 && countBingoO > 0) return 0;
        if(countBingoO > 0 && countO != countX + 1) return 0;
        if(countBingoX > 0 && countO != countX) return 0;
        
        return 1;
    }
    
    private int countDiagonal(String[] board, char c) {
        int count = 0;
        boolean flag = true;
        for(int i = 0; i < 3; i++) {
            if(board[i].charAt(i) != c) {
                    flag = false;
                    break;
            }
        }
        if(flag) count++;
        
        flag = true;
        for(int i = 0; i < 3; i++) {
            if(board[i].charAt(2-i) != c) {
                flag = false;
                break;
            }
        }
        if(flag) count++;
        
        return count;
    }
    
    private int countCol(String[] board, char c) {
        int count = 0;
        for(int i = 0; i < 3; i++) {
            boolean flag = true;
            
            for(int j = 0; j < 3; j++) {
                if(board[j].charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count++;
            }
        }
        return count;
    }
    
    private int countRow(String[] board, char c) {
        int count = 0;
        for(int i = 0; i < 3; i++) {
            boolean flag = true;
            
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) != c) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count++;
            }
        }
        return count;
    }
    
    private int countCharacter(String[] board, char c) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == c) {
                    count++;
                }
            }
        }
        return count;
    }
}