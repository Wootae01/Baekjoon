/**
    음 일단 길이가 20개 이하이니까 음
    최소값?? 그냥 계산 하는거 아닌가 JAZ 이런 경우 때문에 애매하구나
    뒤로 이동이 좀 빡이네
    
    다음 알파벳 이전 알파벳은 판단 가능한데
    
    알파벳 최소 조작하고, 커서 이동 최소 조작은 애초에 따로 동작하네
    그럼 A의 위치가 중요한데 A를 어떻게 하는가..?
    근데 좌우 이득이 음 1개만 존재하는거 아닌가?
    아니지 A가 연속으로 올 수도 있지 
    A를 어떻게 뛰어 넘는가 이네 
    일단 A의 위치를 알아야될거 같고
    JMMAAAAAABAAN
    JMMAAAAAABBAAAAAAAAAAAAAAAAAAAAN
    
    그냥 모든 경우 구하면 음 
    연속된 A 구간 만나면 왼쪽 갔다 오른쪽 가든, 오른쪽 갔다 왼쪽 가든 
    
    
*/
class Solution {
    public int solution(String name) {
        int answer = 0;
        for(int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int tmp = c - 'A';
            if (tmp <= 13) {
                answer += tmp;    
            } else {
                answer += 'Z' - c + 1;
            } 
        }  
        
        int move = 100000000;
        int n = name.length();
        for (int i = 0; i < n; i++) {
            int next = i + 1;

            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, (n - next) * 2 + i);  // 왼쪽 갔다가 오른쪽 가는 경우
            move = Math.min(move, i * 2 + (n - next));  // 오른쪽 갔다가 왼쪽 가는 경우
        }

        
        
        return answer + move;
    }
}