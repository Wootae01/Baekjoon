// a개를 주면 콜라 b개 줌
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) {
            n = n - a;
            answer += b;
            n += b;
        }
        
        return answer;
    }
}