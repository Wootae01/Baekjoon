
/**
    선인장이 가능한 늦게 비를 맞도록 한다..
    와 어렵네 이거 
    결국은 하나씩 움직이면서 모든 경우의 수를 구하는게 맞는거 같긴 한데
    시간복잡도가 되나? 안될거 같고
    
    핵심은 이미 확인한 곳을 다시 확인 안하는 방법이 있다는 건데
    가로로만 구역이 있으면 다시 확인 안해도 될거 같은데
    세로가 햐..
    가장 왼쪽 위 좌표가 구역을 결정하게 되고 일단 << 이것도 좀 중요한거 같은데
    아.. 어렵네 
    
    가로 구간에 해당하는 값을 먼저 계산하고, 
    세로 구간을 붙여서 계산한다
    
*/
import java.util.*;
class Solution {
    
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(map[i], drops.length + 1);
        }
        for (int i = 0; i < drops.length; i++) {
            int y = drops[i][0];
            int x = drops[i][1];
            map[y][x] = i + 1;
        }
        
        int[][] horizontalMin = new int[m][n - w + 1];
        
        for (int i = 0; i < map.length; i++) {
            int[] arr = map[i];
            Deque<Integer> deque = new ArrayDeque<>();    
            for (int j = 0; j < arr.length; j++) {
                while(!deque.isEmpty() && j-w+1 > deque.peekFirst()) {
                    deque.pollFirst();
                }
                while(!deque.isEmpty() && arr[deque.peekLast()] >= arr[j]) {
                    deque.pollLast();
                }
                deque.offerLast(j);
                
                if (j >= w - 1) {
                    horizontalMin[i][j - w + 1] = arr[deque.peekFirst()];
                }
            }
        
        }
        
        
        int[][] rectangleMin = new int[m - h + 1][n - w + 1];
        for (int j = 0; j < horizontalMin[0].length; j++) {
            
            Deque<Integer> deque = new ArrayDeque<>();
            
            for (int i = 0; i < horizontalMin.length; i++) {
                while(!deque.isEmpty() && deque.peekFirst() < i - h + 1) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() &&  horizontalMin[deque.peekLast()][j] >= horizontalMin[i][j]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                
                if (i >= h - 1) {
                    rectangleMin[i - h + 1][j] = horizontalMin[deque.peekFirst()][j];
                }
            }
            
        }
        
        int max = -1;
        int maxY = 0;
        int maxX = 0;

        for (int i = 0; i < rectangleMin.length; i++) {
            for (int j = 0; j < rectangleMin[i].length; j++) {
                if (rectangleMin[i][j] > max) {
                    max = rectangleMin[i][j];
                    maxY = i;
                    maxX = j;
                }
            }
        }
        
        return new int[] {maxY, maxX};
    }
}