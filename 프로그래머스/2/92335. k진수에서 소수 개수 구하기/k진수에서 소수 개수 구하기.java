/**
    음 어려운데
    1. 일단 k진법으로 바꾸기
    2. 소수를 찾는다 이때 소수에 숫자 0이 들어가면 안됨.
    3. 개수 count
    
    적고 보니까 뭐 없네
    k진법을 어떻게 계산하고 계속 나누면 되나?
    0 단위로 split 한 다음에 소수 인지 판단?
*/
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n >= k) {
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);
        
        String changed = sb.reverse().toString();
        String[] split = changed.split("0");
        for (String s : split) {
            if(s.isEmpty()) continue;
            long num = Long.parseLong(s);
            if(isPrimary(num)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrimary(long num) {
        if(num ==1) return false;
        for (long i = 2; i*i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}