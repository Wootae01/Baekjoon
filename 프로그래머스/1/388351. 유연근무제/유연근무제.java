class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        boolean[] check = new boolean[schedules.length];
        for(int i = 0; i < check.length; i++){
            check[i] = true;
        }
        
        int dow = startday % 7;
        
        for(int i = 0; i < 7; i++){
            if(dow == 6 || dow == 0){
                    dow = (dow + 1) % 7;
                    continue;
            }
                
            for(int j = 0; j < schedules.length; j++){
                
                int tmp = schedules[j] + 10;
                if(tmp % 100 >= 60){
                    tmp = (tmp/100 + 1) * 100 + (tmp % 100) % 60;
                }
                
                if(timelogs[j][i] > tmp){
                    check[j] = false;
                }
            }
            dow = (dow + 1) % 7;
        }
        for(int i = 0; i < check.length; i++){
            if(check[i]){
                answer++;
            }
        }
        return answer;
    }
}