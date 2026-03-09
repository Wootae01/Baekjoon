import java.util.*;

class Solution {
    /**
        a 길이가 백만이라...
        어려운데
        
        번호가 더 작은 풍선을 터트린다.. 이건 한번만 가능
        번호가 가장 작은 풍선.. 이거 사용하면 될거 같은데
        
        아 어떤 값 기준으로 왼쪽과 오른쪽에 가장 작은 값 찾고, 
        해당 숫자 이용해서 다 없애면 
        숫자 3개 남음... 
        이 숫자 3개 한번 더 비교하면 되겠네
        
        음.. 근데 기준 값을 정해야될까..? ㅇㅇ 
        
        왼쪽 오른쪽 가장 작은 값은 어떻게 찾음?
        옆으로 옮기면서 정하면 되나?
        
    */
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        int[] leftMin = new int[len];
        int[] rightMin = new int[len];
        
        leftMin[0] = a[0];
        for (int i = 1; i < len; i++) {
            leftMin[i] = Math.min(leftMin[i-1], a[i]);
        }
        
        rightMin[len-1] = a[len-1];
        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], a[i]);
        }
        
        
        for (int i = 0; i < len; i++) {
            
            // 끝 값인 경우 무조건 가능
            if (a[i] == leftMin[i] || a[i] == rightMin[i]) {
                answer++;
            }
            // 가장 큰 값만 아니면 됨
            int max = Math.max(a[i], Math.max(leftMin[i], rightMin[i]));
            if (max != a[i]) {
                answer++; 
            }
            
            
        }
        
        return answer;
    }
    
}