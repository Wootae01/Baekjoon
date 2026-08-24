import java.util.*;

/**
    일단 알아야되는게
    각 상자를 열었는지 체크해야되고,
    모든 상자가 열렸는지 확인하는 것도 필요할거 같고,
    아직 선택 안된 임의의 상자 선택하는 것도 필요하네 
*/
class Solution {
    public int solution(int[] cards) {
        
        boolean[] checks = new boolean[cards.length];
        
        int max1 = 0;
        int max2 = 0;
        
        while(!isOpenAll(checks)) {
            int count = countGroup(cards, checks);
            
            if (count > max1) {
                max2 = max1;
                max1 = count;
            } else if (count > max2) {
                max2 = count;
            }
            
        }
        
        return max1 * max2;
        
    }
    
    private int countGroup(int[] cards, boolean[] checks) {
        int count = 0;
        int n = findOne(checks);
        while(true) {
            if (!checks[n]) {
                count++;
                checks[n] = true;
                n = cards[n] - 1;
            } else {
                break;
            }    
        }
        return count;
    }
    
    private boolean isOpenAll(boolean[] checks) {
        for (int i = 0; i < checks.length; i++) {
            if (!checks[i]) {
                return false;
            }
        }
        return true;
    }
    private int findOne(boolean[] checks) {
        for (int i = 0; i < checks.length; i++) {
            if (!checks[i]) {
                return i;
            }
        }
        return 0;
    }
}