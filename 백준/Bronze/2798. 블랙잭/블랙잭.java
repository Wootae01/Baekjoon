import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int m = s.nextInt();
		int sum = 0;
		int res = -1;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		for(int i = 0; i < n - 2; i++) {
			for(int j = i+1; j < n - 1; j++) {
				for(int k = j+1; k < n; k++) {
					sum = arr[i] + arr[j] + arr[k];
					if(0 <= m - sum && sum > res) {
						res = sum;
					}
				}
			}
		}
		System.out.println(res);
	}
	
}