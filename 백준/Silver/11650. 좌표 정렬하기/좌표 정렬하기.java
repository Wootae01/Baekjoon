import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Point[] arr = new Point[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Point(x, y);
		}
		Arrays.sort(arr, new PointComparator());
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
}

class Point{
	int x, y;
	Point(int x, int y){
		this.x = x; this.y = y;
	}
	public String toString() {
		return x+" " + y;
	}
}

class PointComparator implements Comparator<Point>{
	@Override
	public int compare(Point p1, Point p2) {
		if(p1.x == p2.x) {
			return p1.y - p2.y;
		}
		else {
			return p1.x - p2.x;
		}
	}	
}

