import java.util.HashMap;
import java.util.Map;

class Solution {
    private int distLimit;
    private int splitLimit;
    private Map<String, Long> memo = new HashMap<>();

    public long solution(int dist_limit, int split_limit) {
        this.distLimit = dist_limit;
        this.splitLimit = split_limit;
        if (dist_limit == 0) return 1;
        return dp(0, 1, 1);
    }

    private long dp(int distUsed, long expanding, long splitSoFar) {
        if (distUsed >= distLimit) return expanding;
        if (splitSoFar * 2 > splitLimit) return expanding;

        String key = distUsed + "," + expanding + "," + splitSoFar;
        if (memo.containsKey(key)) return memo.get(key);

        long best = expanding;

        for (int c : new int[]{2, 3}) {
            long newSplit = splitSoFar * c;
            if (newSplit > splitLimit) continue;

            // expand는 항상 최대로
            long expand = Math.min(expanding, distLimit - distUsed);
            long leafNow = expanding - expand;
            long children = expand * c;

            long total = leafNow + dp((int)(distUsed + expand), children, newSplit);
            best = Math.max(best, total);
        }

        memo.put(key, best);
        return best;
    }
}