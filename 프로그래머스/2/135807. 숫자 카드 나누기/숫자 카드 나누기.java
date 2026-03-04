import java.util.*;

class Solution {
    /**
        1. 최대 공약수 구함
        2. 나눠봄
    */
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB);
        
        int maxA = getMaxValid(arrayB, gcdA);
        int maxB = getMaxValid(arrayA, gcdB);

        
        answer = Math.max(maxA, maxB);
        
        return answer;
    }
    
    private static int getMaxValid(int[] arr, int gcd) {
        
        int max = 0;
        for (int i = 1; i * i <= gcd; i++) {
            if(gcd % i == 0) {
                if (!isDivisiable(arr, i)) {
                    max = Math.max(i, max);
                }
                
                int pair = gcd / i;
                if (pair != i && !isDivisiable(arr, pair)) {
                    max = Math.max(pair, max);
                }
            }
        }
        return max;
    }
    
    private static int getGcd(int[] arr) {
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = gcd(gcd, arr[i]);
        }
        return gcd;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    private static boolean isDivisiable(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % n == 0) {
                return true;
            }
        }
        return false;
    }
        
    
    
}