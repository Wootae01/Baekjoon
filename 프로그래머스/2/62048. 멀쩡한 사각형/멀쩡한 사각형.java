/**
    어렵네 와 이거 종이 자른사람 진짜 폐급이네;;
    8 12 -> 2, 3에서 사용할 수 없는 사각형 수 * 4이네
    
    일단 그러면 사용할 수 없는 사각형 수를 어떻게 구하는가 이게 핵심이네
    기울기랑 좀 관련이 있을거 같은데
    이게 어렵네 흠 
    
    와 이걸 어떻게 생각하냐.. 어렵네
    가로선을 넘는 개수, 세로 선을 넘는 개수에 잘린 사각형이 생김 
    근데 격자점을 지날때는 빼줘야되니까 
    
    
    
*/
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        int g = gcd(w, h);
    
        return 1L * w * h - (w + h - g);
    }
    int gcd(int a, int b) {
        while(b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}