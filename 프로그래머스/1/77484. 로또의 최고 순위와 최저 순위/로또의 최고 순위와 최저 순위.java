/**
    음 쉬운데? 
    그냥 0으로 표기된 숫자 제외하고 몇개 일치하는지 비교하면 되겠네
    0 개수 count 하고
    
    비교를 어떻게 하는가인데
    6개밖에 없어서 굳이 정렬할 필요 없이 그냥
    반복문 돌려야겠다
*/
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count0 = 0;
        int count = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            int n = lottos[i];
            
            if (n == 0) {
                count0++;
                continue;
            }
            
            if (findOne(win_nums, n)) {
                count++;
            }
        }
        
        int best = findRank(count+count0);
        int worst = findRank(count);
        
        return new int[]{best, worst};
    }
    
    public int findRank(int n) {
        switch(n) {
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 6;
        }
    }
    
    public boolean findOne(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) return true;
        }
        
        return false;
    }
}