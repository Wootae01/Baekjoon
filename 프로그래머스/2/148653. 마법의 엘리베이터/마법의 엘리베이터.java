import java.util.*;

class Solution {
    /**
      + 버튼을 언제 누르냐 인데
      5를 기준으로 하면 되나? 5보다 크면 + 버튼 누르면 되네
     
    */
    public int solution(int storey) {
        int answer = 0;
        
        int tmp = storey;
        while(tmp > 0) {
            int mod = tmp % 10;
            if (mod > 5) {
                tmp++;
                answer++;
            } else if (mod == 0){
                tmp = tmp / 10;
            } else if (mod < 5) {
                tmp--;
                answer++;
            } else {
                if ((tmp / 10) % 10 >= 5)  {
                    tmp++;
                    answer++;
                } else {
                    tmp--;
                    answer++;
                }
            }
        }
        
       
        return answer;
    }
}