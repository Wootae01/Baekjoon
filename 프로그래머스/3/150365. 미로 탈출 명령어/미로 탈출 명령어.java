import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        String answer = "";
        
        // 불가능한 경우
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || (k - dist) % 2 == 1) return "impossible";
        
        int[][] moves = { {1, 0}, {0, -1}, {0, 1}, {-1, 0} }; // d, l, r, u
        char[] ch = { 'd', 'l', 'r', 'u' };
        
        StringBuilder sb = new StringBuilder();
        while(k > 0) {
            for (int i = 0; i < 4; i++) {
                int nx = x + moves[i][0];
                int ny = y + moves[i][1];
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                
                int d = Math.abs(nx - r) + Math.abs(ny - c);
                if (d <= k - 1 && (k - 1 - d) % 2 == 0) {
                    sb.append(ch[i]);
                    x = nx;
                    y = ny;
                    break;
                }
            }
            k--;
        }
        
        return sb.toString();
    }
    
    static class Node {
        int x;
        int y;
        StringBuilder sb;
        
        Node(int x, int y, StringBuilder sb) {
            this.x = x;
            this.y = y;
        }
    }
    
}