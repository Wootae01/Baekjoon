/*
    이거 뭐냐
    n이 20제한이고 5^20은 log 범위이고
    결국 규칙이 있긴 한데 특정 범위 내의 1의 개수는 음
    5^20을 다 뒤지진 않을텐데
**/
class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        for(long i = l - 1; i <= r - 1; i++){
            boolean flag = true;
            long start = i;
            while(start >= 5){
                if(start % 5 == 2){
                    flag = false;
                    break;
                }
                start /= 5;
            }
            if(start == 2) flag = false;
            if(flag) answer++;
        }
        return answer;
    }
}