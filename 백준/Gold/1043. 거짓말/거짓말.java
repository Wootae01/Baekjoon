import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    static int[] parents;
    static List<Integer> truthPerson;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        truthPerson = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        if (truthNum == 0) {
            System.out.println(m);
            return;
        }else{
            for(int i = 0; i < truthNum; i++) {
                truthPerson.add(Integer.parseInt(st.nextToken()));
            }
        }

        List<List<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            partyList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            partyList.get(i).add(x);
            for (int j = 1; j < partyNum; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                partyList.get(i).add(y);

            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int num : partyList.get(i)) {

                if (truthPerson.contains(find(parents[num]))) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        System.out.println(count);
    }


    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return find(parents[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (truthPerson.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }
        parents[ry] = rx;

    }
}