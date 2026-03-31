import java.util.*;

class Solution {
    /**
        아 음.. 무슨 문제지
        더미노드 0, 그냥이 1
        
        포화 이진트리니까 생성 안되는 경우가 
        부모 노드가 0인 경우 인가? 
        그럼 dfs 돌리면 될듯?
        
        1 3 7 15
    */
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
        
            String binary = Long.toBinaryString(numbers[i]);
            int len = binary.length();
            int size = 1;
            while (size < len) {
                size = size * 2 + 1;
            }
            int diff = size - len;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < diff; j++) {
                sb.append("0");
            }
            
            String padded = sb.toString() + binary;
            
            boolean b = dfs(padded, 0, padded.length() - 1);
            answer[i] = b ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean dfs(String binary, int left, int right) {
        
        // 리프 노드인 경우
        if (left > right) {
            return true;
        }
        
        int mid = (left  + right) / 2;
        char parent = binary.charAt(mid);
        
        // 부모가 더미면 자식도 더미여야됨
        if (parent == '0') {
            for (int i = left; i <= right; i++) {
                if (binary.charAt(i) == '1') return false;
            }
            return true;
        }
        
        boolean b1 = dfs(binary, left, mid - 1);
        boolean b2 = dfs(binary, mid + 1,  right);
        
        return b1 && b2;
    }
    
}