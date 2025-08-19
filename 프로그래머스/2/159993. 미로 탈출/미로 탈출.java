import java.util.*;

class Solution {
    public int solution(String[] maps) {
        /**
            레버 당긴 후 exit 으로 나가야됨..
            여러번 지나갈 수 있음.
            
            bfs인가?? 여러번 지나갈 수 있음을 어떻게 처리해야되냐
            근데 갔던길 또 가는게 최소가 될 수 가 없을거 같긴한데
            레버로 당기러 갈 때 가는길과 출구로 나갈 때 길이 중복일 수 있기 때문에 나온 조건인듯하네
        */
        int answer = 0;
        
        int row = maps.length;
        int col = maps[0].length();
        
        
        
        // 1. 시작 지점 찾기 & 레버 위치 찾기
        Node start = findLocation(maps, row, col, 'S');
        Node lever = findLocation(maps, row, col, 'L');
        
        
        
        // 2. 레버로 이동
        int l = getMinTime(maps, row, col, start, 'L');
        if(l == 0) return -1;
        
        //3. 출구로 이동
        int e = getMinTime(maps, row, col, lever, 'E');
        if(e == 0) return -1;
        
        answer = l + e;
        
        return answer;
    }
    
    private Node findLocation(String[] maps, int row, int col, char des) {
         for (int y = 0; y < row; y++) {
            for(int x = 0; x < col; x++) {
                char c = maps[y].charAt(x);
                if(c == des) {
                    return new Node(y, x);
                }
            }
        }
        return null;
    }
    
    private int getMinTime(String[] maps, int row, int col, Node start, char des) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[row][col];
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        
        queue.offer(start);
        
        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if(maps[cur.y].charAt(cur.x) == des) {
                    return time;
                }
                
                for(int j = 0; j < 4; j++) {
                    int nextY = cur.y + dy[j];
                    int nextX = cur.x + dx[j];
                    
                    if (nextY < 0 || nextY >= row || nextX < 0 || nextX >= col) continue;
                    if(isVisited[nextY][nextX]) continue;
                    
                    if(maps[nextY].charAt(nextX) != 'X') {
                        queue.offer(new Node(nextY, nextX));
                        isVisited[nextY][nextX] = true;    
                    }
                }
            }
            time++;
        }
        
        return 0;
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