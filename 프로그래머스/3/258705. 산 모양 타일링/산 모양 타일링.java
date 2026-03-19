class Solution {
    /**
        흠. 뭔 문제냐
        일단 삼각형 2개를 합쳐서 마름모로 만든다...
        뭔가 규칙이 있을거 같은데
        
        일단 위에 없다고 생각하면 top 이 모두 0이라고 하면
        n = 0, 1
        n = 1, 1 + 2 = 3
        n = 2, 1 + 4 + 3 = 8
        n = 3, 1 + 6 + 10 + 4 = 21
        
        dp 인가
        뭔가 dp 느낌이 오는데 모르겠네
        n값이 1 증가하면 사다리꼴 1개가 증가하는 느낌이니까
        3 * 3 = 9 인데 n = 2 일 때 8이니까
        뭔가를 빼줘야되나 
        사다리꼴이 겹치긴 해 
        
    */
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = (tops[0] == 1) ? 4 : 3;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] * (3 + tops[i-1]) - dp[i-2]) % 10007;
            if (dp[i] < 0) dp[i] += 10007;
        }
        answer = dp[n];
        return answer % 10007;
    }
}