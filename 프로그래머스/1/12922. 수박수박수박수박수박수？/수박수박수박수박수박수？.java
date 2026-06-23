/**
    문자 하나씩 추가하면 될거 같네요 
    그냥 String으로 하면 성능 안좋으니까 StringBuilder 사용하고
*/
class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb.append("수");
            } else {
                sb.append("박");
            }
        }
        return sb.toString();
    }
}