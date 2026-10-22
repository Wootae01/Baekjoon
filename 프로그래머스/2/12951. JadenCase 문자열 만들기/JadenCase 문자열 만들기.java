import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ", -1);
        
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i].isEmpty()) continue;
            arr[i] = arr[i].toLowerCase();
            char c = arr[i].charAt(0);
            if (c >= 'a' && c <= 'z') {
                arr[i] = Character.toUpperCase(c) + arr[i].substring(1);
            }
        }
        
        return String.join(" ", arr);
    }
}