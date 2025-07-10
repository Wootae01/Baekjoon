import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length;
        int m = storage[0].length();
        
        //2차원 문자 storage로 변경
        char[][] cstorage = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cstorage[i][j] = storage[i].charAt(j);
            }
        }
        
        //지게차, 크레인 사용
        for(int i = 0; i < requests.length; i++){
            if(requests[i].length() == 1){
                forklift(n, m, cstorage, requests[i].charAt(0));
            } else{
                crain(n, m, cstorage, requests[i].charAt(0));
            }
        }
        
        //결과
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(cstorage[i][j] != '\0')
                    answer++;
            }
        }
        
        
        return answer;
    }
    private static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    private static void forklift(int n, int m, char[][] cstorage, char c) {
        Queue<Node> erase = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        int[] dy = new int[]{0, 0, 1, -1};
        int[] dx = new int[]{1, -1, 0, 0};
        boolean[][] check = new boolean[n][m];
        //시작 위치 
        for(int j = 0; j < m; j++) {
            if(cstorage[0][j] == '\0'){
                queue.add(new Node(0,j));
                check[0][j] = true;
            } else if(cstorage[0][j] == c){
                erase.add(new Node(0, j));
                check[0][j] = true;
            }
            
            if(cstorage[n-1][j] == '\0'){
                queue.add(new Node(n-1,j));
                check[n-1][j] = true;
            } else if(cstorage[n-1][j] == c){
                erase.add(new Node(n-1, j));
                check[n-1][j] = true;
            }
        }
        for(int i = 0; i < n; i++) {
            if(cstorage[i][0] == '\0'){
                queue.add(new Node(i,0));
                check[i][0] = true;
            } else if(cstorage[i][0] == c){
                erase.add(new Node(i, 0));
                check[i][0] = true;
            }
            if(cstorage[i][m-1] == '\0'){
                queue.add(new Node(i, m-1));
                check[i][m-1] = true;
            } else if(cstorage[i][m-1] == c){
                erase.add(new Node(i, m-1));
                check[i][m-1] = true;
            }
        }
        
        //bfs
        while(!queue.isEmpty()){
            Node current = queue.poll();
            for(int i = 0; i < 4; i++){
                int y = current.y + dy[i];
                int x = current.x + dx[i];
                if(y < 0 || y >= n || x < 0 || x >= m || check[y][x])
                    continue;
                
                if(cstorage[y][x] == '\0'){
                    queue.add(new Node(y, x));
                    check[y][x] = true;
                   
                } else if(cstorage[y][x] == c){
                    erase.add(new Node(y, x));
                    check[y][x] = true;
                }
            }
        }
        while(!erase.isEmpty()){
            Node node = erase.poll();
            cstorage[node.y][node.x] = '\0';
        }
        
    }
    
    private static void crain(int n, int m, char[][] cstorage, char c){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(c == cstorage[i][j]){
                    cstorage[i][j] = '\0';
                }
            }
        }
    }
}