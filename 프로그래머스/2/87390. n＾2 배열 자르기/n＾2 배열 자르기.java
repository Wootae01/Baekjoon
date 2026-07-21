/**
    규칙이 있나? 그냥 하면 되나?
    n 10^7 까지이네
    규칙이 있을거 같은데;;
    일단 2차원 배열을 만들 수 있네
    만들 수 있을거 같기도 하고,,
    근데 배열 10^14인데 이게 가능 한건가?
    음 규칙은 단순한거 같은데
    아 이거 일반화 하기가 어렵네
*/
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        
        long r1 = left / n + 1;
        long c1 = left % n + 1;
        
        long r2 = right / n + 1;
        long c2 = right % n + 1;
        
        List<Long> list = new ArrayList<>();
        while(true) {
            if(r1 == r2 && c1 == c2) {
                list.add(cal(r1, c1));
                break;
            }
            list.add(cal(r1, c1));
            
            if(c1 + 1 > n) {
                c1 = 1;
                r1 = r1 + 1;
            } else {
                c1++;    
            }
            
        }
        
        return list.stream()
            .mapToInt(Long::intValue)
            .toArray();
    }
    
    private long cal(long r, long c) {
        if (c <= r) return r;
        return r + (c - r);
    }
}