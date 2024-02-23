import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        ConferenceTime[] time = new ConferenceTime[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            time[i] = new ConferenceTime(startTime, endTime);
        }
        Arrays.sort(time);
        int endTime = time[0].endTime;
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (time[i].startTime >= endTime) {
                res++;
                endTime = time[i].endTime;
            }
        }
        bw.write(res + "");
        bw.flush(); bw.close();
    }

    static class ConferenceTime implements Comparable<ConferenceTime>{
        private int startTime;
        private int endTime;

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public ConferenceTime(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(ConferenceTime o) {
            if(this.endTime == o.endTime){
                return this.startTime - o.endTime;
            } else {
                return this.endTime - o.endTime;
            }
        }
    }

}