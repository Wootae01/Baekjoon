/*
    쉬운데..? 
    그냥 처음 걸어본 길은 그냥 check하면 되는거 아니냐
    그냥 좌표만 잘 체크해두면 되겠네 ....
    
    아 좌표만 하면 안되는구나 걸어본 길이니까
    그러면 간선을 저장한다?
    
**/
import java.util.*;
class Solution {
    public int solution(String dirs) {
        
        int answer = 0;
        int cy = 5;
        int cx = 5;
        
        Set<Edge> set = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            
            int ny = 0, nx = 0;
            if (c == 'U' && cy - 1 >= 0) {
                ny = cy - 1;
                nx = cx;
            } else if (c == 'L' && cx -1 >= 0) {
                nx = cx - 1;
                ny = cy;
            } else if (c == 'R' && cx +1 <= 10) {
                nx = cx + 1;
                ny = cy;
            } else if (c == 'D' && cy + 1 <= 10) {
                ny = cy + 1;
                nx = cx;
            } else {
                continue;
            }
            if (set.add(new Edge(cy, cx, ny, nx)) && set.add(new Edge(ny, nx, cy, cx))) {
                System.out.printf("%d %d %d %d\n", cy, cx, ny, nx);
                answer++;
            }
            cy = ny;
            cx = nx;
        }
        
        return answer;
    }
    
    class Edge {
        int y1, x1;
        int y2, x2;
        
        Edge(int y1, int x1, int y2, int x2) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = y2;
            this.x2 = x2;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;
            
            Edge edge = (Edge) o;

            return x1 == edge.x1 &&
                   y1 == edge.y1 &&
                   x2 == edge.x2 &&
                   y2 == edge.y2;
        }
        @Override
        public int hashCode() {
            return Objects.hash(y1, x1, y2, x2);
        }
    }
}