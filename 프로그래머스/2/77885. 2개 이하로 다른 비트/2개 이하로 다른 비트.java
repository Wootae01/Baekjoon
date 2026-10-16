/**
    1~2개 다른 수 중 제일 작은 수 ?
    xor연산 하면 되는거 아닌가 두 수를 
    시간복잡도는 모르겠네
    시간초과 나오네.. 금방 나오지 않을까 했는데 1씩 증가시켜도 안되나보네
    
    0111 -> 1000 으로 바뀔때가 핵심이네
    10111 -> 11011
    결국 오른쪽에서 처음으로 나오는 1의 위치? 가 핵심이고,
    
    처음 1이 나온 위치에서 연속된 1이 나온 위치까지 구하면 될거 같네
    음 맨 오른쪽 숫자가 0이면 어처피 무조건 가능이고.. 
*/
import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            answer[i] = getResult(num);
        }
        
        return answer;
    }
    
    private long getResult(long num) {
        long bit = 1L;
        while((num & bit) != 0) {
            bit <<= 1;
        }
        return num + bit - (bit >> 1);
    }
    
}