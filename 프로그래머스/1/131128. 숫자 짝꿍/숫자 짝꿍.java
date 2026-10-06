/**
    string이네? 
    그러면 정렬한 후에
    슬라이딩 윈도우 하면 될듯
    
*/
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        char[] arrX = X.toCharArray();
        char[] arrY = Y.toCharArray();
        Arrays.sort(arrX);
        Arrays.sort(arrY);
        
        int lenX = arrX.length;
        int lenY = arrY.length;
        
        int ix = 0;
        int iy = 0;
        
        List<Character> res = new ArrayList<>();
        while(ix < lenX && iy < lenY) {
            
            // 공통 숫자인 경우
            if(arrX[ix] == arrY[iy]) {
                res.add(arrX[ix]);
                ix++;
                iy++;
            } else if(arrX[ix] > arrY[iy]) {
              iy++;  
            } else {
                ix++;
            }
        }
        if(res.size() == 0) {
            return "-1";
        }
        
        Collections.sort(res, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }
        
        
        String str = sb.toString();
        if(str.charAt(0) == '0') {
            return "0";
        }
        return str;
    }
}