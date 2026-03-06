import java.util.*;

class Solution {
    /**
        1. 주사위 선택
        2. 주사위 합 경우의 수 계산
        3. 승률 계산
        
        음 주사위 선택은 백트레킹. boolean으로 하면 될거 같고
        한쪽만 정하면 나머지는 정해지고..  주사위 1은 고정으로 하면 될듯
        전체 주사위 경우의 수는 nCn/2 / 2 인듯
        
        합, 승률은 그냥 계산하면 될거 같고 <- 이것도 절반만 하면되네 
        근데 절반만 하는건 복잡하니까 그냥 해보자 먼저
        
        승리 횟수 계산은 흠.. 일단 모든 합 경우의수 구하고
        정렬하고 이분 탐색?
        
        모든 합 경우의수는 
        
    */
    
    static List<boolean[]> dices = new ArrayList<>();
    
    public int[] solution(int[][] dice) {
        int[] answer = {};
        
        
        int n = dice.length;
        
        int total = 1;
        
        for (int i = n; i > n / 2; i--) {
            total *= i;
        }
        
        boolean[] visited = new boolean[n];
        selectDice(visited,0, 0, n);

        
        // 승리 횟수 계산을 어떻게 하는가 인데 이제 
        // 모든 합 경우의 수를 구하고, 정렬하고 
        int[] result = new int[dices.size()];
        int index = 0;
        for (boolean[] b : dices) {
            
            List<Integer> diceA = findDiceA(b);
            List<Integer> diceB = findDiceB(b);
            
            List<Integer> hapA = getHap(dice, diceA);
            List<Integer> hapB = getHap(dice, diceB);
            Collections.sort(hapA);
            Collections.sort(hapB);
            
            int win = 0;
            for (int n2 : hapA) {
                win += binarySearch(n2, hapB);
            }
            result[index++] = win;
        }
        int maxIdx = 0;
        int max = result[0];
        for (int i = 1; i < result.length; i++) {
            if (max < result[i]) {
                max = result[i];
                maxIdx = i;
            }
        }
        
        List<Integer> list = findDiceA(dices.get(maxIdx));
        Collections.sort(list);
        int[] arr = list.stream()
                .mapToInt(Integer::intValue)
                .map(v -> v + 1)
                .toArray();
            
        return arr;
       
    }
    
    private int binarySearch(int x, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int n = list.get(mid);
            
            if (n < x) {
                start = mid + 1;
            } else {
                end = mid - 1;  
            }
            
        }
        return start;
    }
    
    
    private List<Integer> getHap(int[][] dice, List<Integer> selected) {
        // 초기화
        int n = selected.get(0);
        List<Integer> result  = new ArrayList<>();
        for (int i = 0; i < dice[n].length; i++) {
            result.add(dice[n][i]);
        }
        
        // 계산
        for (int i = 1; i < selected.size(); i++) {
            n = selected.get(i);
            List<Integer> tmp = new ArrayList<>();
            for (int value : result) {
                for (int v : dice[n]) {
                    tmp.add(value + v);
                }
            }
            result = tmp;
            
        }
        return result;
    }
    
    private List<Integer> findDiceB(boolean[] b) {
        List<Integer> selected = new ArrayList<>();
            for (int i = 0; i < b.length; i++) {
                if (!b[i]) selected.add(i);
            }
        return selected;
    }
    
    private List<Integer> findDiceA(boolean[] b) {
        List<Integer> selected = new ArrayList<>();
            for (int i = 0; i < b.length; i++) {
                if (b[i]) selected.add(i);
            }
        return selected;
    }
    
    private void selectDice(boolean[] visited, int start, int depth, int n) {
        if (depth == n / 2) {
            dices.add(visited.clone());
            return;
        }
        
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectDice(visited, i + 1, depth + 1, n);
                visited[i] = false;
            }
        }
        
        return;
    }
}