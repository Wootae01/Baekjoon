class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int len = Integer.parseInt(video_len.replace(":", ""));
        int cur = Integer.parseInt(pos.replace(":", ""));
        
        int start = Integer.parseInt(op_start.replace(":", ""));
        int end = Integer.parseInt(op_end.replace(":", ""));
        
        
        for(String cmd : commands){
            if(cur >= start && cur <= end){
                cur = end;
            }        
            
            if(cmd.equals("prev")){
                cur = cur - 10;
                if(cur <= 0){
                    cur = 0;
                } else{
                    int s = cur % 100;
                    if(s >= 60){
                        cur = cur - 40;
                    }
                }
            }
            if(cmd.equals("next")){
                cur = cur + 10;
                int s = cur % 100;
                if(s >= 60){
                    cur = cur - 60;
                    cur = cur + 100;
                }
                if(cur > len){
                    cur = len;
                }
            }
        }
        if(cur >= start && cur <= end){
                cur = end;
        }    
        int mm = cur / 100;
        int ss = cur % 100;
        
        return String.format("%02d:%02d", mm, ss);
    }
}