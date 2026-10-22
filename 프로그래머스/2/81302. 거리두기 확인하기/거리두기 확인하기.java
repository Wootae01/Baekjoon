/**
    그냥 8개 다 봐야될거 같은데
    
    bfs인가?
    아니다 그냥 구현문제인거 같다
    중복해서 봐야 될거 같네 칸을 
    시간복잡도는 널널한거 같으니까 뭐
    
*/
import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        
        for (int i = 0; i < places.length; i++) {
            if (checkPlace(places[i])) {
                answer[i] = 1;
            }
        }
        
        
        return answer;
    }
    
    private boolean checkPlace(String[] place) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                char c = place[y].charAt(x);
                if (c != 'P') continue;

                // 상하좌우
                boolean b1 = checkAdjacent(y, x, place);
                if (!b1) return false;
            
                // 대각
                boolean b2 = checkDiagnal(y, x, place);
                if (!b2) return false;
                
                // 상하좌우 2칸
                boolean b3 = checkDistanceTwo(y, x, place);
                if(!b3) return false;
            }
        }
        return true;
    }
    
    private boolean checkDistanceTwo(int y, int x, String[] place) {
        int[] dy = {2, -2, 0, 0};
        int[] dx = {0, 0, -2, 2};

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;

            if (place[ny].charAt(nx) == 'P') {
                int my = y + dy[k] / 2;
                int mx = x + dx[k] / 2;

                if (place[my].charAt(mx) != 'X') {
                    return false;
                }
            }
        }

        return true;
    }
    private boolean checkDiagnal(int y, int x, String[] place) {
        // 대각
        int[] dy = {1, -1, 1, -1};
        int[] dx = {-1, -1, 1, 1};
        
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            
            if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
            
            if (place[ny].charAt(nx) == 'P') {
                if ( place[y].charAt(nx) != 'X'|| place[ny].charAt(x) != 'X') {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkAdjacent(int y, int x, String[] place) {
        
        // 상하좌우
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;

            if (place[ny].charAt(nx) == 'P') return false;
            
        }
        
        return true;
        
    }
    
}