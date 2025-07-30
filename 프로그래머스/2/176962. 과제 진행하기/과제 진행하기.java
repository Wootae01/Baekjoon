import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        /**
            새로운 과제 시작 하는게 우선
            과제를 끝내는 순서대로 이름 담아 리턴
            1. 시작 순서대로 정렬
            2. 과제 하다가 새로운 과제 시작하면 그 과제 실행 시키고,
               하다가 멈춘 과제는 stack에 저장해둠.
            3. 과제 수행시간, 새로운 과제 시작 시간, stack에 있는 시간 고려해서 순서대로 저장
            
            정렬은 어떻게 함?? -> 시간을 초단위로 바꿔서 정렬.
            클래스 하나 만드는게 좋을듯
        */
        String[] answer = new String[plans.length];
        List<Subject> subjects = new ArrayList<>();
        for(int i = 0; i < plans.length; i++){
            String name = plans[i][0];
            int start = parseTime(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);
            subjects.add(new Subject(name, start, playtime));
        }
        
        //1. 정렬
        Collections.sort(subjects);
        int current = subjects.get(0).start;
        int end = current + subjects.get(0).playtime;
        int count = 0;
        
        Stack<Subject> stack = new Stack<>();
        
        for (int i = 1; i < subjects.size(); i++) {
            Subject subject = subjects.get(i);
            current = subject.start;
            
            //이전 과제 끝나기 전 새로운 과제 시작
            if(current < end) {
                Subject pre = subjects.get(i-1);
                pre.playtime = end - current;
                stack.push(pre);
                end = current + subject.playtime;
                
            } else if(current == end){ //새로운 과제 시작 시간과 이전 과제 끝난 시간 같은 경우
                
                Subject pre = subjects.get(i-1);
                answer[count++] = pre.name;
                end = current + subject.playtime;
                
            } else { //이전 과제 끝난 후 새로운 과제 시작
                Subject pre = subjects.get(i-1);
                answer[count++] = pre.name;
                
                //남는 시간 동안 stack 있는 과제 실행시킴
                int idle = current - end;
                while(!stack.isEmpty() && idle > 0){    
                    Subject tmp = stack.pop();
                    
                    if(tmp.playtime - idle <= 0) {
                        answer[count++] = tmp.name;
                        idle -= tmp.playtime;
                    } else {
                        tmp.playtime -= idle;
                        stack.push(tmp);
                        idle = 0;
                    }   
                }
                end = current + subject.playtime;
            }
        }
        answer[count++] = subjects.get(subjects.size() - 1).name;
        while(!stack.isEmpty()) {
            Subject tmp = stack.pop();
            answer[count++] = tmp.name;
        }
        return answer;
    }
    private static int parseTime(String time){
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        
        return m + h * 60;
    }
}

class Subject implements Comparable<Subject>{
    String name;
    int start;
    int playtime;
    Subject(String name, int start, int playtime){
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }
    @Override
    public int compareTo(Subject o){
        return this.start - o.start;
    }
}