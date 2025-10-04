class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        /**
            트럭에 최대 상자 cap개 실을 수 있음.
            배달, 수거 함
            그냥 단순하게 가장 먼 거리부터 배달하고, 수거하면 되는거 아님?
            cap 만큼 싣고
            
            먼 거리부터 배달, 수거 하니까
            이걸 저장할 변수가 필요하고,
            현재 수거한 개수, 배달한 개수 count할 것도 필요하고.
            
            
        */
        long answer = 0;
        
        
        int curDIdx = deliveries.length - 1;
        int curPIdx = deliveries.length - 1;
        while (curDIdx >= 0 &&deliveries[curDIdx] == 0) {
                curDIdx--;
        }
        
        while (curPIdx >= 0 && pickups[curPIdx] == 0) {
            curPIdx--;
        }
        
        while (curDIdx >= 0 || curPIdx >= 0) {
            int countD = 0;
            int countP = 0;
            
            
            int distance = Math.max(curDIdx+1, curPIdx+1);
            
            while(countD < cap && curDIdx >= 0) {
                deliveries[curDIdx]--;
                countD++;
                if(deliveries[curDIdx] <= 0) {
                    while (curDIdx >= 0 &&deliveries[curDIdx] == 0) {
                        curDIdx--;
                    }
                }
                
            }
            
            while(countP < cap && curPIdx >= 0) {
                pickups[curPIdx]--;
                countP++;
                if(pickups[curPIdx] <= 0) {
                    while (curPIdx >= 0 && pickups[curPIdx] == 0) {
                        curPIdx--;
                    }       
                }
                
            }
            
            answer += distance * 2;
        }
        
        return answer;
    }
}