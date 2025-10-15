import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        /**
            bfs로 모든 경우의 수 다 계산하면 될 듯 하네
            중복된 수를 큐에 넣지 않으려면 어떻게 해야될까
            그냥 배열 만들어야지 뭐..
        */
        int answer = 0;
        boolean[] check = new boolean[y + 1];
        boolean possible = false;
        int tmp = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == y) {
                    possible = true;
                    break;
                }

                tmp = cur + n;
                if (tmp <= y && !check[tmp]) {
                    queue.offer(tmp);
                    check[tmp] = true;
                }

                tmp = cur * 2;
                if (tmp <= y && !check[tmp]) {
                    queue.offer(tmp);
                    check[tmp] = true;
                }

                tmp = cur * 3;
                if (tmp <= y && !check[tmp]) {
                    queue.offer(tmp);
                    check[tmp] = true;
                }
            }
            if (possible) return answer;
            
            answer++;
        }
        
        
        return -1;
    }
}