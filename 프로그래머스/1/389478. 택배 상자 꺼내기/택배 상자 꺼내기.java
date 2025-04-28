class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int tmp = num;
        
        while(tmp <= n){
            
            int idx = tmp % w;
            if(idx == 0){
                tmp += 1;
            } else{
                tmp += (w*2) -(idx*2 - 1);
            }
            answer++;    
        }
        
        return answer;
    }
}