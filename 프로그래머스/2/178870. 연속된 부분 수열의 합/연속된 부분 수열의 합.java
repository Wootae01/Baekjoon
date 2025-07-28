class Solution {
    public int[] solution(int[] sequence, int k) {
        /*
            수열 문제
            1. 수열의 길이가 정해져 있지 않다.
                -> 모든 길이에 대해 수열 구해야됨.
            2. 수열은 비내림 차순으로 정렬되어 있고, sequence에서 연속된 숫자네?
                -> 슬라이딩 윈도우 사용하면 됨
        */
        int[] answer = new int[2];
        if(sequence[0] == k) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        
        int start = 0;
        int end = 1;
        int len = 1000001;
        int sum = sequence[start] + sequence[end];
        while(start <= end && end < sequence.length) {
            if(sum > k) {
                sum -= sequence[start++];
            } else if(sum < k) {
                end++;
                if(end >= sequence.length) break;
                sum += sequence[end];
            } else {
                if(end - start < len) {
                    answer[0] = start;
                    answer[1] = end;
                    len = answer[1] - answer[0];
                }
                end++;
                if(end >= sequence.length) break;
                sum += sequence[end];
            }
            
        }
        return answer;
    }

}