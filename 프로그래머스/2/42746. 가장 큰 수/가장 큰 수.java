/**
    뭐냐
    모르겠는데?
    
    두 숫자를 어떤 숫자로 붙였을 때 더 큰수가 되는가 
*/
import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        
        Integer[] arr = Arrays.stream(numbers)
            .boxed()
            .toArray(Integer[]::new);
        
        Arrays.sort(arr, (a, b) -> {
            String ab = a + "" + b;
            String ba = b + "" + a;
            
            return ba.compareTo(ab);
        });
        
        String result = Arrays.stream(arr)
            .map(String::valueOf)
            .collect(Collectors.joining());
                
        if (result.charAt(0) == '0') return "0";
        return result;
    }
}