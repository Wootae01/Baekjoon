/**
    음 어렵네 
    알파벳이 5개로만 되어 있구나
    대문자로만 이루어져있고
    
    뒤에서부터 가야지 ㅇㅇ
    문자가 5개밖에 없다
    A AA AAA AAAA AAAAA AAAAB AAAAC
    B 시작이면 음 
    
    아 맨 앞자리가 바뀌면 A -> E 로 바뀌면 음
    A 1개
    AA~ 5개
    AAA~ AUU 25개
    AAAA~ AUUU 125ㅐ
    ~ 625개
    
    총 781개
    
    그럼 AA-> AE이면  156개
    AAA->AAE 이면  31개
                6개
                1개
*/
class Solution {
    public int solution(String word) {
        int answer = 0;
        int n = word.length();
        
        int[] weight = {781, 156, 31, 6, 1};
        
        for (int i = 0; i < word.length(); i++) {
            int idx = "AEIOU".indexOf(word.charAt(i));
            answer += weight[i] * idx + 1;
        }
        
        
        return answer;
    }
}