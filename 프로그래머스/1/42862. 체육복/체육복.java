/**
    여벌 체육복 가져온 사람도 도난당할 수 있다..
    그냥 이중  for 문 돌리면 되겠는데? 
    아 근데 앞사람한테 빌려주는가 뒷사람 한테 빌려주는가 이건 있겠구나
    
    n이 30까지 밖에 안된다,,,
    일단 배열 하나 만들어서 학생별 체육복 개수 다 계산하고
    
*/
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 학생별 체육복 수 계산
        int[] students = new int[n+1];
        Arrays.fill(students, 1);
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]]--;

        }
        for (int i = 0; i < reserve.length; i++) {
            students[reserve[i]]++;
        }
        
        // 반복문 돌면서 확인
        for (int i = 1; i < students.length; i++) {
            if (students[i] >= 1) continue;
            
            // 체육복 개수 0인 학생이면 양 옆 학생에게 물어봄
            if (students[i-1] > 1) {
                students[i]++;
                students[i-1]--;
            } else if (i < n && students[i+1] > 1) {
                students[i]++;
                students[i+1]--;
            }
        }
        
        for (int i = 1; i < students.length; i++) {
            if (students[i] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}