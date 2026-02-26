import java.util.*;

class Solution {
    /**
        dp 인가? 
        왼손을 움직인 경우랑 오른손을 움직인 경우를 계산해서 최소값을 구해야될거 같은데
        그리고 어떻게 이동할지 경로도 알아야되는데 
        숫자판 배열도 필요하겠네
        왼손, 오른손 위치도 저장해야되네
        
    */
    private static final int INF = Integer.MAX_VALUE / 4;
    public int solution(String numbers) {
       if (numbers == null || numbers.length() == 0) return 0;

        // 키패드 배치 (행 4, 열 3)
        char[][] keypad = {
            {'1','2','3'},
            {'4','5','6'},
            {'7','8','9'},
            {'*','0','#'}
        };

        // 문자 -> 인덱스 매핑 (0..11)
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 3; c++) {
                map.put(keypad[r][c], idx++);
            }
        }

        // 좌표 배열: index -> (r,c)
        int[][] coord = new int[12][2];
        idx = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 3; c++) {
                coord[idx][0] = r;
                coord[idx][1] = c;
                idx++;
            }
        }

        // 1) cost 계산: 모든 쌍 최단 이동비 (플로이드)
        int n = 12;
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
            cost[i][i] = 1; // 제자리 누름 비용
        }

        // 인접(8방향) 가중치 설정: 상하좌우=2, 대각=3
        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
        for (int u = 0; u < n; u++) {
            int r = coord[u][0];
            int c = coord[u][1];
            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= 4 || nc < 0 || nc >= 3) continue;
                int v = nr * 3 + nc;
                // orthogonal (맨해튼 거리 1) -> 2, else diagonal -> 3
                if (Math.abs(dr[k]) + Math.abs(dc[k]) == 1) cost[u][v] = 2;
                else cost[u][v] = 3;
            }
        }

        // Floyd–Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (cost[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (cost[k][j] == INF) continue;
                    if (cost[i][k] + cost[k][j] < cost[i][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }

        
        // dp
        // 초기화
        int len = numbers.length();
        int[][][] dp = new int[len + 1][12][12];

        for (int i = 0; i <= len; i++) {
            for (int L = 0; L < 12; L++) {
                Arrays.fill(dp[i][L], INF);
            }
        }

        int startL = map.get('4');
        int startR = map.get('6');

        dp[0][startL][startR] = 0;
        
        for (int i = 0; i < len; i++) {
            int target = map.get(numbers.charAt(i));
            
            for (int L = 0; L < 12; L++) {
                for (int R = 0; R < 12; R++) {
                    if (dp[i][L][R] == INF) continue;
                    
                    int cur = dp[i][L][R];
                    
                    // 타겟이 왼손 위에 있으면 왼손만 가능
                    if (L == target) {
                        dp[i+1][L][R] =
                            Math.min(dp[i+1][L][R],
                                     cur + cost[L][target]);
                        continue;
                    }

                    // 타겟이 오른손 위에 있으면 오른손만 가능
                    if (R == target) {
                        dp[i+1][L][R] =
                            Math.min(dp[i+1][L][R],
                                     cur + cost[R][target]);
                        continue;
                    }
                    
                    // 왼손 이동
                    dp[i+1][target][R] = Math.min(dp[i+1][target][R], cur + cost[L][target]);
                    
                    // 오른손 이동
                    dp[i+1][L][target] = Math.min(dp[i+1][L][target], cur + cost[R][target]);
                }
            }
        }
    
        // 답
        int answer = INF;

        for (int L = 0; L < 12; L++) {
            for (int R = 0; R < 12; R++) {
                answer = Math.min(answer, dp[len][L][R]);
            }
        }
        return answer;
    }
   
}