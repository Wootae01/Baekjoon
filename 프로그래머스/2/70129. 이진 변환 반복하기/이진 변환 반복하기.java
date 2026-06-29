/**
    2^n - 1 이게 그건가 1로만 이루어진 거고 
    
    
*/
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int remove = 0; // 제거된 0 개수
        int c = 0;
        while(!s.equals("1")) {
            int count = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
        
            remove += s.length() - count; 
            s = Integer.toBinaryString(count);            
            c++;
        }
        
        
        return new int[]{c, remove};
    }
}