import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        boolean[][] check = new boolean[n][m];
        int[] cal = new int[m];
        
        Queue<Node> queue = new LinkedList<>();
        
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        
        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n; i++){
                if(check[i][j]) continue;
                check[i][j] = true;
                if(land[i][j] == 0) continue;
                
                queue.offer(new Node(i,j));
                
                int count = 1;
                boolean[] row = new boolean[m];
                row[j] = true;
                while(!queue.isEmpty()) {
                    Node current = queue.poll();
                    for(int k = 0; k < 4; k++){
                        int y = current.y + dy[k];
                        int x = current.x + dx[k];
                        if(y < 0 || y >= n || x < 0 || x >= m) continue;
                        if(check[y][x]) continue;
                        
                        check[y][x] = true;
                        if(land[y][x] == 1) {
                            row[x] = true;
                            queue.offer(new Node(y, x));
                            count++;
                        }
                        
                    }
                }
                for(int k = 0; k < m; k++) {
                    if(row[k]) {
                        cal[k] += count;
                    }
                    
                }
                
            }
        }
        for(int i = 0; i < m; i++) {
            answer = Math.max(cal[i], answer);
        }
        
        return answer;
    }
    class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
    }
}
}
