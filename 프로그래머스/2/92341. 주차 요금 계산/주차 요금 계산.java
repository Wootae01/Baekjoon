import java.util.*;

class Solution {
    /**
        그냥 계산하면 되는거 같은데 뭐 없네
        Map에 기록해두면 될듯? ㅇㅇ
        
    */
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int baseTime = fees[0]; // 기본 시간
        int baseFee = fees[1]; // 기본 요금
        int unitTime = fees[2]; // 단위 시간
        int unitPrice = fees[3]; // 단위 요금
        
        Map<String, String> map = new HashMap<>(); // 차량 번호, 입차 시간
        Map<String, Integer> exitMap = new HashMap<>(); // 차량 별 요금
        
        for (int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            
            if (arr[2].equals("IN")) {
                map.put(arr[1], arr[0]);
            } else {
                // 시간 계산
                int totalMinutes = getTotalMinutes(map.get(arr[1]), arr[0]);
                
                // 요금 계산
                int prev = exitMap.getOrDefault(arr[1], 0);
                exitMap.put(arr[1], prev + totalMinutes);
                map.remove(arr[1]);
            }
            
        }
        
        // 출차 내역 없는 경우
        for (String key : map.keySet()) {
            String time = map.get(key);
            int totalMinutes = getTotalMinutes(time, "23:59");
            int prev = exitMap.getOrDefault(key, 0);
            exitMap.put(key, prev + totalMinutes);
        }

        answer = exitMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .mapToInt(e -> calculateFee(
                e.getValue(),
                baseTime,
                baseFee,
                unitTime,
                unitPrice))
            .toArray();
        
        return answer;
    }
    
    private int getTotalMinutes(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");

        int startMinutes = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int endMinutes = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

        return endMinutes - startMinutes;
    }
    private int calculateFee(int totalMinutes, int baseTime, int baseFee,
                         int unitTime, int unitPrice) {
        if (totalMinutes <= baseTime) {
            return baseFee;
        }

        int extra = (int) Math.ceil((double) (totalMinutes - baseTime) / unitTime)
                * unitPrice;

        return baseFee + extra;
    }
}