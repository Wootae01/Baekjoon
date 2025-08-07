import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length();
        char[][] boards = new char[row][col];
        Node start = null;
        // board 2차원 배열로 초기화
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length(); x++) {
                char c = board[y].charAt(x);
                boards[y][x] = c;
                if(c == 'R') start = new Node(y, x);
            }
        }
        
        //bfs
        Queue<Node> queue = new LinkedList<>();
        boolean[][] check = new boolean[row][col];
        queue.offer(start);
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if(boards[cur.y][cur.x] == 'G') return answer;
                
                for (int k = 0; k < 4; k++) {
                    
                    Node next = collideNode(boards, check, cur, dy[k], dx[k]);
                    if(next != null) {
                        queue.offer(next);
                    }
                    
                    
                }
            }
            answer++;
        }
            
        
        return -1;
    }
    
    
    // 충돌 위치 반환
    static Node collideNode(char[][] boards, boolean[][] check, Node cur, int dy, int dx) {
        
        int row = boards.length;
        int col = boards[0].length;
        
        int ny = cur.y;
        int nx = cur.x;
        while(true) {
            int ty = ny + dy;
            int tx = nx + dx;
            if(ty < 0 || ty >= row || tx < 0 || tx >= col || boards[ty][tx] == 'D') break;
            ny = ty;
            nx = tx;
        }
        
        if (!check[ny][nx]) {
            check[ny][nx] = true;
            return new Node(ny, nx);
        }
        return null;
    }
}

class Node {
    int x;
    int y;
    Node (int y, int x) {
        this.x = x;
        this.y = y;
    }
}