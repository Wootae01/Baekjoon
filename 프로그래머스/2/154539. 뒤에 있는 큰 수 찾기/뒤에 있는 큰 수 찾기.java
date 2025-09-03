import java.util.*;


class Solution {
    public int[] solution(int[] numbers) {
        /**
            뒷 큰수가 뭔지 판단하려면 일단
            원래 있던 위치와 숫자를 기억해야됨. 그럼 같이 저장하면 되겠네
            그 후 큐에 넣어서 하나씩 꺼내서 확인하면 된는데 음.. 정렬이 필요하니 우선 순위 큐에 넣으면 되나?    
        */
        int len = numbers.length;
        int[] answer = new int[len];
        
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> a.num - b.num);
        
        for (int i = 0; i < len; i++) {
            int num = numbers[i];
            
            while(!pq.isEmpty() && pq.peek().num < num) {
                Info info = pq.poll();
                answer[info.idx] = num;
            }
            pq.offer(new Info(i, num));
        }
        
        while (!pq.isEmpty()) {
            Info info = pq.poll();
            answer[info.idx] = -1;
        }
        
        return answer;
    }
}

class Info {
    int idx;
    int num;
    
    Info (int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}
