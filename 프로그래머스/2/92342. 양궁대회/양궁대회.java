/**
    가장 큰 점수 차로 이긴다..
    어떤 과녁 점수를 얼마나(?) 맞추는가 이건데
    이걸 어떻게 count 함?
    브루트포스인거 같고 
    어파치보다 많이 맞추는가 아니면 맞추지 않느냐 이거구나
    dfs로 득점한 경우, 안한 경우 모두 계산
*/
class Solution {
    
    public static int max = -1;
    public static int[] result = new int[11];
    
    public int[] solution(int n, int[] info) {
        
        dfs(info, n, 0, new int[11]);
        
        if (max <= 0) return new int[] {-1};
        return result;
    }
    
    private int calculateScore(int[] info, int[] res) {
        int sum = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0 && res[i] == 0) {
                continue;
            }

            if (info[i] < res[i]) {
                sum += (10 - i);
            } else {
                sum -= (10 - i);
            }
        }

        return sum;
    }
    
    private void dfs(int[] info, int n, int depth, int[] res) {

        if (depth == 11) {
            // 남은 화살 처리
            int[] finalRes = res.clone();
            finalRes[10] += n;
            
            // 점수 계산 
            int score = calculateScore(info, finalRes);
            
            
            if (score > max) {
                max = score;
                result = finalRes.clone();
            } else if (max == score) {
                // 같은경우 가장 낮은 점수를 더 많이 맞힌 경우
                for (int i = 10; i >= 0; i--) {
                    if (finalRes[i] > result[i]) {
                        result = finalRes.clone();
                        break;
                    } else if (finalRes[i] < result[i]) {
                        break;
                    }
                }
            }
            return;
        }
        
        int remain = 0;
        int[] copy = res.clone();
        
        // 득점한 경우
        if (info[depth] + 1 <= n) {
            copy[depth] = info[depth] + 1;
            remain = n - info[depth] - 1;
            dfs(info, remain, depth+1, copy);
        }

        // 득점 못한 경우
        remain = n;
        dfs(info, remain, depth+1, res);
        
    }

}