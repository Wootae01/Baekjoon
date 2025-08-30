import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    public int solution(String[][] book_time) {

        int answer = 0;
        
        List<Time> books = new ArrayList<>();
        for(int i = 0; i < book_time.length; i++) {
            books.add(new Time(book_time[i][0], book_time[i][1]));
        }
        
        books.sort(Comparator.comparing(t -> t.startTime));
     
        
        PriorityQueue<LocalTime> pq = new PriorityQueue<>();
        
        for (Time cur : books) {
            
            while(!pq.isEmpty() && pq.peek().plusMinutes(10).compareTo(cur.startTime) <= 0) {
                pq.poll();    
            }
            
            pq.offer(cur.endTime);
            answer = Math.max(answer, pq.size());
            
        }
        
        return answer;
    }
}

class Time {
    LocalTime startTime;
    LocalTime endTime;
    
    Time(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.startTime = LocalTime.parse(startTime, formatter);
        this.endTime = LocalTime.parse(endTime, formatter);
    }
}