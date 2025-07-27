class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long c1 = (long)r1*r1;
        long c2 = (long)r2*r2;
        for(long x = 1; x <= r2; x++) {
            long x2 = x*x; 
            
            long minY = c1 > x2 ? (long)Math.ceil(Math.sqrt(c1 - x2)) : 1;
            long maxY = (long)Math.floor(Math.sqrt(c2 - x2));
            if(maxY >= minY){
                answer += (maxY - minY + 1);    
            }
        }
        answer = answer + (r2 - r1 + 1);
        answer = answer * 4;
        return answer;
    }
}