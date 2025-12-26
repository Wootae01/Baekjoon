import java.util.*;

class Solution {
    // 1. 정렬
    // 2. 나머지 계산
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        // 1. 정렬
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col -1] == o2[col-1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });
         // 2. 나머지 합 계산
        List<Integer> list = new ArrayList<>();
        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j] % (i+1);
            }
            list.add(sum);
        }

        // 3. xor 연산
        answer = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            answer = answer ^ list.get(i);
        }
        return answer;
    }
   
}