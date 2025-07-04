import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        int digit = q[0].length;
        int[] arr = new int[digit];
        
        
        boolean[] check = new boolean[n+1];
        
        answer = decode(q, ans, arr, check, n, 0, 1, 0);
        
        
        return answer;
    }
    
    private static boolean isAnswer(int[] arr, int[][] q, int[] ans){
        int digit = arr.length;
        for(int i = 0; i < q.length; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < digit; j++){
                set.add(arr[j]);
                set.add(q[i][j]);
            }
            if(set.size() != (digit + digit - ans[i])){
                return false;
            }
        }
        return true;
    }
    
    private static int decode(int[][] q, int[] ans, int[] arr, boolean[] check, int n, int depth, int start, int answer){
        if (depth == arr.length) {
            if (isAnswer(arr, q, ans)) {
                return answer + 1;
            }
            return answer;
        }

        for (int i = start; i <= n; i++) {
            if (check[i]) continue;

            arr[depth] = i;
            check[i] = true;
            answer = decode(q, ans, arr, check, n, depth + 1, i+1, answer);
            check[i] = false;
        }
        return answer;
    }
}