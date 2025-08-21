import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        /**
            그냥 bfs인거 같네
        */
       
        int row = maps.length;
        int col = maps[0].length();
        
        List<Integer> list = new ArrayList<>();
        boolean[][] check = new boolean[row][col];
        
        for (int y = 0; y < row; y++) {
            for(int x = 0; x < col; x++) {
                if(maps[y].charAt(x) != 'X' && !check[y][x]) {
                    check[y][x] = true;
                    list.add(bfs(maps, row, col, check, new Node(y, x)));
                }
            }
        }
        if(list.isEmpty()) return new int[]{-1};
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);

        
        return answer;
    }
    private int bfs(String[] maps, int row, int col, boolean[][] check, Node start) {
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        
        int count = 0;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            count += maps[cur.y].charAt(cur.x) - '0';
            for(int i = 0; i < 4; i++) {
                int y = dy[i] + cur.y;
                int x = dx[i] + cur.x;
                if(y < 0 || y >= row || x < 0 || x >= col) continue;
                if(check[y][x]) continue;
                if(maps[y].charAt(x) == 'X') continue;
                
               
                check[y][x] = true;
                queue.offer(new Node(y, x));
            }
        }
        
        return count;
    }
}

class Node {
    int y;
    int x;
    
    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}