import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		Set<Integer> s = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.compareTo("all") == 0) {
				s.clear();
				for(int j = 1; j <= 20; j++) {
					s.add(j);
				}
			}
			else if(command.compareTo("empty") == 0) {
				s.clear();
			}
			else {
				int n = Integer.parseInt(st.nextToken());
				
				if(command.compareTo("add") == 0) 
					s.add(n);
				
 				else if(command.compareTo("remove") == 0)
 					s.remove(n);
 				
 				else if(command.compareTo("check") ==0) {
 					if(s.contains(n)) {
 						bw.write(1 + "\n");
 					}
 					else {
 						bw.write(0 + "\n");
 					}
 				}
 					
				
 				else if(command.compareTo("toggle") == 0) {
 					if(s.contains(n)) {
 						s.remove(n);
 					}
 					else {
 						s.add(n);
 					}
 				}
			}
		}
		bw.flush();
		bw.close();
	}
}