import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Person[] arr = new Person[n];
		for(int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			arr[i] = new Person(Integer.parseInt(tmp[0]), tmp[1]);
		}
		Arrays.sort(arr);
		for(int i = 0; i < n; i++) {
			bw.write(arr[i].toString());
		}
		bw.flush();
		bw.close();
	}
}

class Person implements Comparable<Person>{
	static int num = 0;
	int id = num++;
	int age;
	String name;
	Person(int age, String name){
		this.age = age; this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s%n", age, name);
	}
	
	@Override
	public int compareTo(Person p1) {
		if(this.age == p1.age) {
			return this.id - p1.id;
		}
		return this.age - p1.age;
	}
}

